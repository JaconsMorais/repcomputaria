/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bancodosamigos.util;

import bancodosamigos.classes.Banco;
import bancodosamigos.classes.Cliente;
import bancodosamigos.classes.Conta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * LMFAO - Long and Mobilized File Access Operations
 * @author user
 */
public class BancoLMFAO {
    public static final String dirArquivo = "Arquivo/";
    public static final String nomeArquivo = "Banco.xml";

    public static void criaArquivo() throws IOException{
        File f = new File(dirArquivo);

        if(!f.exists())
            f.mkdir();

        f = new File(dirArquivo + nomeArquivo);

        if(!f.exists()){
            f.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(dirArquivo + nomeArquivo));
            out.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
            out.write("<dados>");
            out.write("</dados>");
            out.close();
        }
    }

    public static File carregaArquivo() throws IOException{
        return new File(dirArquivo + nomeArquivo);
    }

    public static void salvaXML(Document XML){
            try{
                //Realiza a saida do XML para o arquivo
                Transformer trans = TransformerFactory.newInstance().newTransformer();
                trans.setOutputProperty(OutputKeys.INDENT, "yes");
                trans.transform(new DOMSource(XML), new StreamResult(new FileWriter(new File(dirArquivo + nomeArquivo))));
            } catch (Exception ex){
            }
    }

    public static Document getXML(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;

        try {

            File XML = BancoLMFAO.carregaArquivo();
            
            db = dbf.newDocumentBuilder();
            return db.parse(XML);
            
        } catch (Exception ex) {
        	System.out.print("");
            return db.newDocument();
        }
    }

    public static void insereAgencia(Banco banco){
        Document XML = BancoLMFAO.getXML();

        try{
        	Node root = XML.getElementsByTagName("dados").item(0);
            Element bancoTag = XML.createElement("banco");

            bancoTag.setAttribute("nome", banco.getNome());
            bancoTag.setAttribute("agencia", String.valueOf(banco.getnAgencia()));

            root.appendChild(bancoTag);
            
            BancoLMFAO.salvaXML(XML);

        } catch (Exception ex) {
        }
    }

    public static void insereConta(Conta conta, Cliente cliente){
        Document XML = BancoLMFAO.getXML();
        try{
            Element bancoTag = null;
            NodeList agenciaTags = XML.getElementsByTagName("banco");

            for(int i = 0;i < agenciaTags.getLength();i++){
                String s = agenciaTags.item(i).getAttributes().getNamedItem("agencia").getNodeValue();
                if(s.equals(String.valueOf(conta.getnAgencia()))){
                    Element contaTag = XML.createElement("conta");

                    contaTag.setAttribute("numero", String.valueOf(conta.getnConta()));
                    contaTag.setAttribute("saldo", String.valueOf(conta.getSaldo()));

                    Element clienteTag = XML.createElement("cliente");

                    clienteTag.setAttribute("nome", cliente.getNome());
                    clienteTag.setAttribute("CPF", String.valueOf(cliente.getCPF()));

                    contaTag.appendChild(clienteTag);
                    agenciaTags.item(i).appendChild(contaTag);
                    break;
                }
            }

            BancoLMFAO.salvaXML(XML);
        } catch (Exception ex) {
        }

    }

    public static void updateXML(Banco banco, Conta conta, Cliente cliente){
        Document XML = BancoLMFAO.getXML();

        Node root = XML.getElementsByTagName("dados").item(0);
        NodeList agenciaTags = root.getChildNodes();

        for(int i = 0;i < agenciaTags.getLength();i++){
        	if(agenciaTags.item(i) instanceof Element){
                String s = agenciaTags.item(i).getAttributes().getNamedItem("agencia").getNodeValue();
                if(s.equals(String.valueOf(banco.getnAgencia()))){

                    NodeList contaTags = agenciaTags.item(i).getChildNodes();

                    for(int j = 0;j < contaTags.getLength();j++){
                        if(contaTags.item(j) instanceof Element){
                            String t = contaTags.item(j).getAttributes().getNamedItem("numero").getNodeValue();
                            if(t.equals(String.valueOf(conta.getnConta()))){
                                contaTags.item(j).getAttributes().getNamedItem("saldo").setNodeValue(String.valueOf(conta.getSaldo()));
                            }
                        }
                    }
                }
        	}
        }
        
        BancoLMFAO.salvaXML(XML);
    }

    public static ArrayList getBancoContaCliente(int agencia, int conta){
        ArrayList list = new ArrayList();
        Document XML = BancoLMFAO.getXML();

        Node root = XML.getElementsByTagName("dados").item(0);
        NodeList agenciaTags = root.getChildNodes();

        for(int i = 0;i < agenciaTags.getLength();i++){
        	if(agenciaTags.item(i) instanceof Element){
                String s = agenciaTags.item(i).getAttributes().getNamedItem("agencia").getNodeValue();
                if(s.equals(String.valueOf(agencia))){
                    Banco b = new Banco();
                    b.setNome(agenciaTags.item(i).getAttributes().getNamedItem("nome").getNodeValue());
                    b.setnAgencia(Integer.parseInt(s));

                    list.add(b);

                    NodeList contaTags = agenciaTags.item(i).getChildNodes();

                    for(int j = 0;j < contaTags.getLength();j++){
                        if(contaTags.item(j) instanceof Element){
                            String t = contaTags.item(j).getAttributes().getNamedItem("numero").getNodeValue();
                            if(t.equals(String.valueOf(conta))){
                                Conta c = new Conta();
                                c.setnAgencia(b.getnAgencia());
                                c.setnConta(Integer.parseInt(t));
                                c.setSaldo(Double.parseDouble(contaTags.item(j).getAttributes().getNamedItem("saldo").getNodeValue()));

                                list.add(c);

                                NodeList clienteTags = contaTags.item(j).getChildNodes();

                                for(int k = 0;k < clienteTags.getLength();k++){
                                    if(clienteTags.item(k) instanceof Element){
                                        Cliente cli = new Cliente();
                                        cli.setnConta(c.getnConta());
                                        cli.setNome(clienteTags.item(k).getAttributes().getNamedItem("nome").getNodeValue());
                                        cli.setCPF(Long.parseLong(clienteTags.item(k).getAttributes().getNamedItem("CPF").getNodeValue()));

                                        list.add(cli);
                                    }
                                }
                            }
                        }
                    }
                }
        	}
        }

        return list;
    }
}
