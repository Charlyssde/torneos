module com.cc.torneos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    
    opens com.cc.torneos to javafx.fxml;
    exports com.cc.torneos;
}
