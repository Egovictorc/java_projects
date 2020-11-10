package application;

import javafx.scene.control.Label;

public class ControllerMethods {

    private Label expression, value;
    private double sum = 0;
    String operator = "";


    private void compute() {
        double digits = Double.parseDouble(value.getText());

        switch (operator) {
            case "+":
                sum += digits;
//			setOperator(btnText);
                break;
            case "-":
                sum -= digits;
                break;
            case "x":
                sum *= digits;
//			setOperator("*");
                break;
            default:
                sum /= digits;
                break;
        }
    }
}
