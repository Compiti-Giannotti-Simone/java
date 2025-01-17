module it.giannotti {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.giannotti to javafx.fxml;
    exports it.giannotti;
}
