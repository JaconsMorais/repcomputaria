/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.util;

import atarefatorcompevolutiva.model.Tarefa;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thales
 */

@Deprecated
public class Persistencia implements Converter{
    private File XML;
    private XStream xstream;
    public String dirArquivoDefault = "Arquivo/";
    public String nomeArquivoDefault = "Tarefas.xml";

    public Persistencia(XStream xstream){
        this.xstream = xstream;
        xstream.alias("tarefa", Tarefa.class);
        xstream.aliasField("id", Tarefa.class,"idTarefa");
        xstream.aliasField("nome", Tarefa.class,"nomeTarefa");
        xstream.aliasField("data-inicial", Tarefa.class,"dataInicio");
        xstream.aliasField("data-final", Tarefa.class,"dataFinal");
        xstream.aliasField("local", Tarefa.class,"localTarefa");
        xstream.aliasField("total-horas", Tarefa.class,"totalHoras");
        xstream.aliasField("horas-trabalhadas", Tarefa.class,"horasTrabalhadas");

        try {
            XML = getXML();
        } catch (IOException ex) {

        }
    }

    public Persistencia(XStream xstream,String dirArquivoDefault, String nomeArquivoDefault) {
        this.xstream = xstream;
        xstream.alias("tarefa", Tarefa.class);
        xstream.aliasField("id", Tarefa.class,"idTarefa");
        xstream.aliasField("nome", Tarefa.class,"nomeTarefa");
        xstream.aliasField("data-inicial", Tarefa.class,"dataInicio");
        xstream.aliasField("data-final", Tarefa.class,"dataFinal");
        xstream.aliasField("local", Tarefa.class,"localTarefa");
        xstream.aliasField("total-horas", Tarefa.class,"totalHoras");
        xstream.aliasField("horas-trabalhadas", Tarefa.class,"horasTrabalhadas");
        this.dirArquivoDefault = dirArquivoDefault;
        this.nomeArquivoDefault = nomeArquivoDefault;
        
        try {
            XML = getXML();
        } catch (IOException ex) {
            
        }
    }

    public static void addToXML(){

    }

    public static void removeToXML(){

    }

    public static void updateXML(){

    }

    public static Tarefa findXMLNode(){
        return new Tarefa();
    }

    private File getXML() throws IOException{
        File f = new File(dirArquivoDefault);

        if(!f.exists())
            f.mkdir();

        f = new File(dirArquivoDefault + nomeArquivoDefault);

        if(!f.exists()){
            f.createNewFile();
            /*
            BufferedWriter out = new BufferedWriter(new FileWriter(dirArquivo + nomeArquivo));
            out.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
            out.write("<dados>");
            out.write("</dados>");
            out.close();
            */
        }

        return f;
    }

    public static ArrayList<Tarefa> getElementsFromXML(){
        return new ArrayList<Tarefa>();
    }

    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        Tarefa tarefa = (Tarefa) o;

        writer.startNode("id");
        writer.setValue(String.valueOf(tarefa.getIdTarefa()));
        writer.endNode();

        writer.startNode("nome");
        writer.setValue(tarefa.getNomeTarefa());
        writer.endNode();

        writer.startNode("data-inicial");
        writer.setValue(String.valueOf(tarefa.getDataInicio()));
        writer.endNode();

        writer.startNode("data-final");
        writer.setValue(String.valueOf(tarefa.getDataFinal()));
        writer.endNode();

        writer.startNode("categoria");
        writer.setValue(tarefa.getCategoria());
        writer.endNode();

        writer.startNode("local");
        writer.setValue(tarefa.getLocalTarefa());
        writer.endNode();

        writer.startNode("porcentagem");
        writer.setValue(String.valueOf(tarefa.getPorcentagem()));
        writer.endNode();

        writer.startNode("total-horas");
        writer.setValue(String.valueOf(tarefa.getTotalHoras()));
        writer.endNode();

        writer.startNode("horas-trabalhadas");
        writer.setValue(String.valueOf(tarefa.getHorasTrabalhadas()));
        writer.endNode();

        writer.startNode("comentários");
        writer.setValue(tarefa.getComentários());
        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean canConvert(Class type) {
        return type.equals(Tarefa.class);
    }
}
