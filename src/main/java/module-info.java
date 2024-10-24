module co.edu.uniquindio.preparcil2.universidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.desktop;
    requires java.logging;

    opens co.edu.uniquindio.preparcil2.universidad to javafx.fxml;
    exports co.edu.uniquindio.preparcil2.universidad;

    opens co.edu.uniquindio.preparcil2.universidad.model to javafx.fxml;
    exports co.edu.uniquindio.preparcil2.universidad.model;

    opens co.edu.uniquindio.preparcil2.universidad.viewController to javafx.fxml;
    exports co.edu.uniquindio.preparcil2.universidad.viewController;

    opens co.edu.uniquindio.preparcil2.universidad.controller to javafx.fxml;
    exports co.edu.uniquindio.preparcil2.universidad.controller;

}