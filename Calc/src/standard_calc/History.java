package standard_calc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class History {
    static Map<String, String> hst;
    @FXML
    FlowPane hst_cont;

    /* **************************mouse click handler ****************************** */
    public void onMouseClicked(MouseEvent e) {
        Button btn = (Button) e.getSource();

        toggleHistory();
    }

    /* ******************************* history toggler *********************************/
    void toggleHistory() {
        hst_cont.setVisible(!hst_cont.isVisible());

       /* if(hst_cont.isVisible()) {
            hst_cont.setVisible(false);
        } else {
            hst_cont.setVisible(true);
        }*/
    }
/*
  void addHistory(String expression, String result) {
        hst.put(expression, result);
    }

    Map<String, String> getHistory() {
        return this.hst;
    }*/

    public void showHistory() {
        Set<Map.Entry<String, String>> hstSet = hst.entrySet();

        for (Map.Entry<String, String> record : hstSet) {
            System.out.println(record.getKey() + " =" + record.getValue());
        }

       /*
       Iterator<Map.Entry<String, String>> iter = hstSet.iterator();
       while (iter.hasNext()) {
            Map.Entry<String, String> record = iter.next();

            System.out.println(record.getKey() + " =" + record.getValue());
        }*/
    }

    public static void main(String[] args) {
       /* History history = new History();
        history.addHistory("4+5", "9");

        Set<Map.Entry<String, String>> hstSet = hst.entrySet();
        Iterator<Map.Entry<String, String>> iter = hstSet.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> record = iter.next();

            System.out.println(record.getKey() + " =" + record.getValue());
        }*/

    }
}
