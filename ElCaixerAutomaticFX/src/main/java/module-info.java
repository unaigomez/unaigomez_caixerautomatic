module com.mycompany.elcaixerautomaticfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.elcaixerautomaticfx to javafx.fxml;
    exports com.mycompany.elcaixerautomaticfx;
}
