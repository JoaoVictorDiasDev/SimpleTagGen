module com.joao.dias {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.desktop;


    opens com.joao.dias to javafx.fxml;
    exports com.joao.dias;
}
