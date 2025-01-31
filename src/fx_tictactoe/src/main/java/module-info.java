module it.giannotti {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens it.giannotti to javafx.fxml;
    exports it.giannotti;
}
