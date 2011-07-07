package jena.controlador;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException { }
      
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            
            PrintWriter out = response.getWriter();

            out.println("<b>[1] Carregando dados...</b></br>");
            response.setContentType("text/html");
            out.println("<b>[2] Carregando bean...</b></br>");
            //Instancia model como SportModelBean que irá herdar os atributos da classe
            SportModelBean model = new SportModelBean();

            /*O model instanciado acima em cada uma de suas funções receberá
             o valor digitado nos texts respectivos pelo método request.getparameter
             fará a conversão de peso, tamanho das maos, tamanho dos pés, e a altura
             para uma string que o RDF possa identificar pelo sparql*/
            model.setPeso( request.getParameter("txtpeso") );
			model.setAltura( request.getParameter("txtaltura"));
            model.setEnvergadura( request.getParameter("txtenvergadura"));
            model.setMassaMuscular( request.getParameter("txtmassa"));
            model.setTamanhoMaos( request.getParameter("txtmaos"));
            model.setSexo( request.getParameter("txtsexo"));
            model.setTamanhoPes( request.getParameter("txtpes"));

            /*result do tipo ResultSet recebe o return da função SportSPARQL
             que foi passado em model com os parâmetros da pagina .jsp
             já manipulados e alterados*/
            ResultSet result = jena.controlador.SportSPARQL.sparql( model );
            out.println("<b>[3] Obtendo resposta... </b></br>");
            String s = null;

            /*s receberá a string com o(s) esporte(s) encontrados na consulta
             SportSPARQL e então o modifica para uma String sendo apenas o esporte
             retornado e então posteriormente a imprime na tela*/
            s = ResultSetFormatter.asXMLString(result);
            out.println("<b>[4] ESPORTE RECOMENDÁVEL : "+ s +"</b><br>");
            out.print("<b> Linhas alteradas : "+result.getRowNumber());

            jena.controlador.SportSPARQL.close();
			response.setContentType("text/html");
    }
 
}
