module it.giannotti {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires javafx.graphics;

    opens it.giannotti to javafx.fxml;
    opens it.giannotti.Controller to javafx.fxml;
    exports it.giannotti;
    exports it.giannotti.Controller;
}