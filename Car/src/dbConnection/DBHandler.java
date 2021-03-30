package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Configs {



    Connection dbconnection;
    public Connection getConnection() {
        String connectionString = "jdbc:mysql://"+Configs.dbhost+":"+Configs.dbport+ "/"+Configs.dbname+ "?serverTimezone=UTC&autoReconnect=true&useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbconnection = DriverManager.getConnection(connectionString, Configs.dbuser, Configs.dbpass);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return dbconnection;
    }
}
