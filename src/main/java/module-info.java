module rps {
    requires java.naming;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;


    opens rps to javafx.fxml;
    exports rps;
    exports rps.gui.controller;
    opens rps.gui.controller to javafx.fxml;
    exports rps.gui to javafx.graphics;
}