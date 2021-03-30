package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dbConnection.DBHandler;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private DBHandler handler;
    @FXML
    private ImageView progress;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton signup;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXCheckBox remember;
    @FXML
    private JFXButton login;

    private Connection connection;
    private PreparedStatement pst;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        progress.setVisible(false);
        username.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");
        handler = new DBHandler();
    }

    @FXML
    public void loginAction(ActionEvent e) {
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev -> {
            //System.out.println("Login successfully");
        });
        pt.play();

        // retrieve data from database
        connection = handler.getConnection();
        String sql = "Select * from car_review where Fullname=? and Password =?";
     try {
         pst = connection.prepareStatement(sql);
         pst.setString(1, username.getText());
         pst.setString(2, password.getText());
         int count = 0;
         ResultSet rs =  pst.executeQuery();

         while(rs.next()) {
             count+=1;
         }
         if (count == 1) {
             System.out.println("Login Successfully");
         } else {
             System.out.println("Username or Password is incorrect");
         }
     } catch(SQLException sq) {
         sq.printStackTrace();
     } finally {
         try {
             connection.close();
         } catch(SQLException se) {
             se.printStackTrace();
         }
     }

    }

    @FXML
    public void signUp(ActionEvent e1) throws IOException {
    /*    Button btn = (Button)e1.getSource();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SignUp.FXML"));
        Scene scene = btn.getScene();
        scene.setRoot(root);*/

        //Scene scene = new Scene(root);

        login.getScene().getWindow().hide();
        Stage signup = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SignUp.FXML"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.setTitle("Sign up Page");
        signup.show();
        signup.setResizable(false);

    }
}
