package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Label expression, value;
    private double sum = 0;
    String operator = "";

    private boolean isEqual = false;
//	public void changeScene(String btnText) {
//		Parent home = FXMLLoader.load(getClass().getResource("home.fxml"));
//		Parent next = FXMLLoader.load(getClass().getResource("next.fxml"));
//

//	}

    @FXML
    private void onMouseClicked(MouseEvent e) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent next = FXMLLoader.load(getClass().getResource("next.fxml"));

        Button btn = (Button) e.getSource();
        Scene scene = btn.getScene();

        String btnText = btn.getText();

        switch (btnText) {
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
                handleNumber(btnText);
                break;
            case "+":
            case "-":
            case "x":
            case "/":
                handleOperator(btnText);
                break;
            case "=":
                System.out.println("hello");
//			scene.setRoot(next);
                displayResult();
                break;
            case "back home":
                scene.setRoot(home);
//			displayResult();
                break;

            case "CLS":
                clear();
                break;
            case "DEL":
                delChar();
                break;
        }
    }

    private void compute() {
        double digits = Double.parseDouble(value.getText());

        switch (operator) {
            case "+":
                sum += digits;
                break;
            case "-":
                sum -= digits;
                break;
            case "x":
                sum *= digits;
                break;
            default:
                sum /= digits;
                break;
        }
    }

    private void handleOperator(String btnText) {

        double digits = Double.parseDouble(value.getText());

        if (!operator.isEmpty()) {
            compute();
        } else {
            sum = digits;

        }
        setOperator(btnText);
        System.out.println("sum is " + sum);
        expression.setText(expression.getText() + " " + value.getText() + " " + btnText);
        value.setText("0");
    }

    public void setOperator(String opr) {
        operator = opr;
    }

    private void checkEquals() {
        if (isEqual) {
            clear();
            isEqual = false;
        }
    }

    private void handleNumber(String btnText) {
        checkEquals();

        if (value.getText().equals("0")) {
            value.setText(btnText);
        } else {
            value.setText(value.getText() + btnText);
        }
    }

    private void setExpression(String val) {
        expression.setText(expression.getText() + " " + value.getText());
    }

    private Label getExpression() {
        return expression;
    }

    private String removeZero(String result) {
        String[] resArr = result.split("\\.");
        String strRes = resArr[1];

        if (!strRes.equals("0")) {
            return result;
        }
        return resArr[0];
    }

    private void displayResult() {
        setExpression(operator.concat(value.getText()));
        compute();

        String result = String.valueOf(sum);
        value.setText(removeZero(result));
        isEqual = true;
//		System.out.println(sum);
//		System.out.println("show result ");
    }

    //	public boolean isEmpty(String val) {
//		return val.length() == 0;
//	}
    public void delChar() {

        String text = getExpression().getText();
        if (!text.isEmpty()) {
            int length = text.length();
            expression.setText(text.substring(0, length - 1).strip());
        }
    }

    public void clear() {
        value.setText("0");
        expression.setText("");
        operator = "";
        sum = 0;
    }
}
