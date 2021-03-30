package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbConnection.DBHandler;

public class SignupController implements Initializable {

    @FXML
    private ImageView progress;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private ToggleGroup gender;
    @FXML
    private JFXRadioButton male, female, other;

    @FXML
    private JFXTextField location;

    @FXML
    private JFXButton login, signup;

    private Connection connection;
    PreparedStatement pst;
    DBHandler handler;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        progress.setVisible(false);
        username.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");
        location.setStyle("-fx-text-inner-color: #a0a2ab;");
    }

    @FXML
    public void signupAction(ActionEvent e) {
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev -> {
            System.out.println("Signup successfully");
        });
        pt.play();

        //saving data;
        String insert = "INSERT INTO CAR_REVIEW(Fullname, Password, Gender, Location)" + "values(?,?,?,?)";
        handler = new DBHandler();
        connection = handler.getConnection();

        try {
            pst = connection.prepareStatement(insert);
        } catch(SQLException el) {
            el.printStackTrace();
        }

        try {
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            pst.setString(3, getGender());
            pst.setString(4, location.getText());

            pst.executeUpdate();
        } catch(SQLException sq) {
            sq.printStackTrace();
        }
    }

    @FXML
    public void loginAction(ActionEvent ae) throws IOException {
        signup.getScene().getWindow().hide();
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginMain.fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.setTitle("Login Page");
        login.show();
        login.setResizable(false);
    }

    public String getGender() {
        String gen = "";
        if (male.isSelected()) {
            gen = "Male";
        } else if (female.isSelected()) {
            gen = "Female";
        } else if (other.isSelected()) {
            gen = "";
        }
        return gen;
    }
}