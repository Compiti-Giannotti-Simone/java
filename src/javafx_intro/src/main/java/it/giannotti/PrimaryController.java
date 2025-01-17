package it.giannotti;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Label outputLabel;
    @FXML
    private TextField inputField;

    @FXML
    private void inputText() throws IOException {
        outputLabel.setText(!inputField.getText().isEmpty() ? inputField.getText() : "No text in field");
    }
}
