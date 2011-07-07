package jena.controlador;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;


public class SportSPARQL {
        private static QueryExecution consulta;
        private static ResultSet results;

        public static ResultSet  sparql (SportModelBean sport) throws IOException {
		// Abre o gráfido do RDF à partir do sistema
		InputStream input = new FileInputStream(new File("C:\\Users\\Thales\\Documents\\NetBeansProjects\\SparqlWebRenan\\rdf\\esportes.rdf"));
		// Cria um modelo vazio na memória e popula ela à partir do gráfico
		Model model = ModelFactory.createMemModelMaker().createModel(null);
		//Model model = null;
		model.read(input, null);
		// Base nula do URI, desde que os URIs sejam absolutos
		input.close();
		// Cria uma nova query
        String queryString2 =
			"PREFIX kb: <http://protege.stanford.edu/kb#> " +
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"SELECT DISTINCT ?esporte " +
			"WHERE {" +
			"?kb kb:esporte ?esporte ." +
			"?kb kb:peso ?peso ." +
			"FILTER ( ?peso = '"+sport.getPeso()+"' )" +
			"?kb kb:altura ?altura . "+
			"FILTER (?altura = '"+sport.getAltura()+"')" +
			"?kb kb:envergadura ?envergadura . "+
			"FILTER (?envergadura = '"+sport.getEnvergadura()+"')" +
			"?kb kb:tamanho_mãos ?tamanho_mãos . "+
			"FILTER (?tamanho_mãos = '"+sport.getTamanhoMaos()+"')" +
			"?kb kb:tamanho_pés ?tamanho_pés . "+
			"FILTER (?tamanho_pés = '"+sport.getTamanhoPes()+"')" +
			"?kb kb:massa_muscular ?massa_muscular . "+
			"FILTER (?massa_muscular = '"+sport.getMassaMuscular()+"')" +
			"?kb kb:sexo ?sexo . "+
			"FILTER (?sexo = '"+sport.getSexo()+"')" +
			"}"+
			"ORDER BY ?esporte";

		Query query = QueryFactory.create(queryString2);

		// Executa a query e obtêm resultados
		consulta = com.hp.hpl.jena.query.QueryExecutionFactory.create(query, model);
		results = consulta.execSelect();

		// Returna os resultados em forma de string
		return results;
        }
        public static void close(){
            consulta.close();
        }

}




