package standard_calc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    double sum = 0;
    @FXML
    Label current, expression;
    String operator = "";

    public void onMouseClicked(MouseEvent e) {
        Button btn = (Button) e.getSource();
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
                numhandler(btnText);
                break;
            // operator cases
            case "-":
            case "+":
            case "x":
            case "/":
            case "CE":
            case "C":
                oprhandler(btnText);
                break;
            case ".":
                dothandler();
                break;
            case "+/-":
                changesign();
                break;
            case "=":
                displayResult();
                break;
        }
    }

    void numhandler(String num) {
        String oldText = current.getText();
        String newText;

        if (!oldText.equals("0")) {
            newText = oldText + num;
        } else {
            newText = num;
        }
        current.setText(newText);
    }

    void oprhandler(String opr) {
        operator = opr;
        historyHandler();

    }

    void historyHandler() {
        String oldExp = expression.getText();
        String cur = current.getText();
        expression.setText(String.format("%s%s%s", oldExp, cur, operator));
        current.setText("");
    }

    void dothandler() {
        boolean isDecimal = checkDecimal();
        String oldText = current.getText();
        if(!isDecimal) {
            current.setText(String.format("%s%s", oldText, ".") );
        }
        System.out.println(isDecimal);
    }

    boolean checkDecimal() {
        String cur = current.getText();
        Pattern p = Pattern.compile("[0-9-]+\\.[0-9]*");
        Matcher match = p.matcher(cur);
        boolean b = match.matches();

        if (b) {
            return true;
        }
        return false;
    }

    void changesign() {
        boolean isDecimal = checkDecimal();
        String cur = current.getText();

        if (cur.isBlank()) {
            return;
        }
        if (isDecimal) {
            double num = Double.parseDouble(cur);
            current.setText(String.valueOf(-1 * num));
        } else {
            int num = Integer.parseInt(cur);
            current.setText(String.valueOf(-1 * num));
        }
    }

    void displayResult() {

    }
}
