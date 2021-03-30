package standard_calc2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class SampleController {

    @FXML
    private Label current;
    @FXML private Label expression;
    String operator = "";

    public void onMouseClicked(MouseEvent e) {
        Button btn = (Button)e.getSource();
        String btnText = btn.getText();



        System.out.println("btnText "+ btnText);
        switch(btnText) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
                    -> numHandler(btnText);

        }
    /*    switch(btnText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                numHandler(btnText);
                break;
            case "-":
            case "+":
            case "x":
            case "/":
                oprHandler(btnText);
                break;
        }*/
    }

    private void numHandler(String btnText) {

        String oldText = current.getText();
        if(oldText.equals("0")) {
            current.setText(btnText);
        } else {
            current.setText(oldText+ btnText);
        }

    }

    private void oprHandler(String oprText) {
        String curText = current.getText();

        expression.setText(expression.getText() + curText + oprText);
        current.setText("0");
    }


}
