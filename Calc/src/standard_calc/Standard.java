package standard_calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Standard extends Application {

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("standard.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Standard Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        //primaryStage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
