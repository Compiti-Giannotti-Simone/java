module it.giannotti {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;

    opens it.giannotti to javafx.fxml;
    exports it.giannotti;
}
