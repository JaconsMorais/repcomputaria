 package BancoLCP.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
        private Connection connection;

        public Conexao(int inicio,int finish) throws SQLException {
            try {
                String driver = "org.firebirdsql.jdbc.FBDriver";
                String urls[] = {"jdbc:firebirdsql:localhost:/opt/firebird/data/Funcionário.fdb","jdbc:firebirdsql:localhost:/opt/firebird/data/Cliente.fdb","jdbc:firebirdsql:localhost:/opt/firebird/data/Transação.fdb"};
                String user = "root";
                String password = "root";

                Class.forName(driver);
                for(int i = inicio; i <= finish;i++)connection = DriverManager.getConnection(urls[i], user, password);
            } catch (ClassNotFoundException e){
                e.printStackTrace();
                throw new SQLException(e.getMessage());
            }
        }

        public Connection getConnection(){
            return connection;
        }
}