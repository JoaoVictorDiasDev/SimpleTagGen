module com.joao.dias {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.desktop;
    requires java.sql;
    requires org.apache.poi.ooxml;


    opens com.joao.dias to javafx.fxml;
    exports com.joao.dias;
    exports com.joao.dias.controllers;
    opens com.joao.dias.controllers to javafx.fxml;
    exports com.joao.dias.utils;
    opens com.joao.dias.utils to javafx.fxml;
    exports com.joao.dias.configs;
    opens com.joao.dias.configs to javafx.fxml;
}
