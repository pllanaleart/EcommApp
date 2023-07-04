module com.example.ecommapp {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.ecommapp.dashboard to javafx.fxml;
            
            requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.ecommapp to javafx.fxml;
    exports com.example.ecommapp;
    exports com.example.ecommapp.dashboard;
}