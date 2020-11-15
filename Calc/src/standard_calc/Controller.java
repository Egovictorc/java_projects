package standard_calc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {
    double sum = 0;

    @FXML Label current, expression;
    String operator = "";
    boolean showedResult = false;

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
                numHandler(btnText);
                break;
            // operator cases
            case "-":
            case "+":
            case "x":
            case "/":
                oprHandler(btnText);
                break;
            case "CE":
                clear();
                break;
            case "C":
                clearAll();
                break;
            case ".":
                dotHandler();
                break;
            case "+/-":
                changeSign();
                break;
            case "=":
                displayResult();
                break;
            case "%":
                percentHandler();
                break;
        }
    }

    void numHandler(String num) {
        String oldText = current.getText();
        String newText;

        if (oldText.equals("0")) {
            newText = num;
        } else {
            newText = oldText + num;
        }
        current.setText(newText);
    }

    /************************************* method: operator handler  *********************************/
    void oprHandler(String opr) {
        String sumText = current.getText();

        if (operator.isBlank()) {
            sum = Double.parseDouble(sumText);
        } else {
            compute();
        }
        operator = opr;

        expressionHandler();
        /*************************************** check if result has been shown *********************************/
        if (showedResult) {
            showedResult = false;
        }
    }

    void compute() {
        double cur = Double.parseDouble(current.getText());
        switch (operator) {
            case "+":
                sum += cur; // sum = sum + cur;
                break;
            case "-":
                sum -= cur; // sum = sum - cur;
                break;
            case "x":
                sum *= cur; // sum = sum * cur;
                break;
            case "/":
                sum /= cur; // sum = sum / cur;
                break;
        }
        System.out.println("sum " + sum);

    }

    /************************************* method: expression handler *********************************/
    void expressionHandler() {
        String oldExp = expression.getText();
        String cur = current.getText();

        //expression.setText(String.format("%s%s%s", oldExp, cur, operator));
        if(!showedResult) {
            expression.setText(oldExp+cur+operator);
        } else {
            expression.setText(cur+operator);
        }
        current.setText("");
    }

    void dotHandler() {
        boolean isDecimal = checkDecimal();
        String oldText = current.getText();
        if (!isDecimal) {
            current.setText(String.format("%s%s", oldText, "."));
        }
        System.out.println(isDecimal);
    }

    boolean checkDecimal() {
        String cur = current.getText();
        /*Pattern pattern = Pattern.compile("[0-9-]+\\.[0-9]*");
        Matcher match = pattern.matcher(cur);
        boolean matches = match.matches();

        if (matches) {
            return true;
        }
        return false;
        */
        if (cur.matches("[0-9-]+\\.[0-9]+")) {
            return true;
        };
        return false;
    }

    void changeSign() {
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

    void clear() {
        String cur = current.getText();

        /*String cur = current.getText();
        if(!cur.isBlank()) {
            current.setText(cur.substring(0, cur.length()-1));
        }*/

        // using stringbuilder
        StringBuilder curBuilder = new StringBuilder();
        curBuilder.append(cur);

        if (!cur.isBlank()) {
            curBuilder.deleteCharAt(curBuilder.length() - 1);
            current.setText(curBuilder.toString());
        }
    }

    void clearAll() {
        operator = "";
        sum = 0;
        current.setText("0");
        expression.setText("");
    }

    void displayResult() {
        compute();
        //String cur = current.getText();
        //String oldExpression = expression.getText();
        //expression.setText(oldExpression.concat(cur));
        //expression.setText(oldExpression.concat(cur));

        operator = "";

        expressionHandler();
        String res = String.valueOf(sum);
        current.setText(removeZero(res));
        showedResult = true;
        System.out.println("res "+ res);
    }

    void percentHandler() {
        //String cur = current.getText();
        double cur = Double.parseDouble(current.getText());
        current.setText(String.valueOf(cur / 100));
    };

    String removeZero(String res) {
        if(res.matches("[0-9]+\\.0")) {
            return res.substring(0, res.length() - 2);
        } else {
            return res;
        }
    }

}
