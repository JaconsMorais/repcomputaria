/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thales
 */
public class BuscasRDF extends QueryEngine{
     private String Query;

     public void BuscaPerfil(){
          Query = "";

          ExecutaQuery(Query,null);

          FechaQuery();
     }

     public void BuscaProfissao(){
          Query = "";

          ExecutaQuery(Query,null);
          
          FechaQuery();
     }
}
