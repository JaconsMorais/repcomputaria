/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author Thales
 */
public class QueryEngine {
    private static QueryExecution consulta;
    private static ResultSet results;

    public ResultSet ExecutaQuery(String QuerySPARQL,InputStream input) throws IOException{
        // Abre o gráfido do RDF à partir do sistema
		//InputStream input = new FileInputStream(new File("C:\\Users\\Thales\\Documents\\NetBeansProjects\\SparqlWebRenan\\rdf\\esportes.rdf"));
		// Cria um modelo vazio na memória e popula ela à partir do gráfico
		Model model = ModelFactory.createMemModelMaker().createModel(null);
		//Model model = null;
		model.read(input, null);
		// Base nula do URI, desde que os URIs sejam absolutos
		input.close();
		// Cria uma nova query

		Query query = QueryFactory.create(QuerySPARQL);

		// Executa a query e obtêm resultados
		consulta = com.hp.hpl.jena.query.QueryExecutionFactory.create(query, model);
		results = consulta.execSelect();

		// Returna os resultados em forma de string
		return results;
    }

    public void FechaQuery(){
        consulta.close();
    }
}
