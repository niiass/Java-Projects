module org.example.mcdonald {
    requires javafx.controls;
    requires javafx.fxml;
    requires flyway.core;
    requires com.fasterxml.jackson.databind;
    requires java.sql;
    requires java.desktop;


    opens org.example.mcdonald to javafx.fxml;
    exports org.example.mcdonald;
    exports org.example.mcdonald.controllers;
    opens org.example.mcdonald.controllers to javafx.fxml;
}