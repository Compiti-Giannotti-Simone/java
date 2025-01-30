package it.giannotti;

import java.io.IOException;

import javax.script.ScriptException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField field;

    private String operation = "";

    @FXML
    private void press_button(ActionEvent event) throws IOException {
        Button clicked = (Button) event.getSource();
        String symbol = clicked.getText();
        
        operation += symbol;
        updateScreen();
    }
    @FXML
    private void press_del() throws IOException {
        if(operation.isEmpty()) return;
        operation = operation.substring(0, operation.length()-1);
        updateScreen();
    }
    @FXML
    private void press_c() throws IOException {
        operation = "";
        updateScreen();
    }
    @FXML
    private void press_equals() throws IOException, ScriptException {
        try {
        operation = Calculator.calculate(operation);
        } catch(Exception e) {
            operation = "Syntax Error";
            updateScreen();
        }
        updateScreen();
        operation = "";
    }
    @FXML
    private void updateOperation() throws IOException {
        operation = field.getText();
    }

    private void updateScreen() {
        field.clear();
        field.appendText(operation);
    }
}
