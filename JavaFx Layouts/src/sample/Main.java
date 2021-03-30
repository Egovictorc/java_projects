package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    //"jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
    private String CONNECTION_STRING = "jdbc:sqlserver://localhost:1433;databaseName=students";
    String SERVER_NAME = "sa";
    String PASSWORD  = "1234";

    Connection conn;


    void connectDB() {
        try {
            //Class.forName("com.microsoft.sqlserver");
            conn = DriverManager.getConnection(CONNECTION_STRING, SERVER_NAME, PASSWORD);

            if(conn != null) {
                System.out.println("connected to db "+ conn);

                queryDB();
            } else {
                System.out.println("not connected to db");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    void queryDB() {
        String sel_rec = "select * from dbo.STUDENT";
        try{
            PreparedStatement ptmt = conn.prepareStatement(sel_rec);
            ResultSet rs = ptmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int salary = rs.getInt(4);
                System.out.println(String.format("%s; %s; %s; %s", id, name, age, salary));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        connectDB();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
