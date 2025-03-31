package org.example.mcdonald;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IllegalStateException nullPointerException) {
            System.out.println(nullPointerException.toString());
        }

        System.out.println(getClass().getResource("HomePage.fxml"));
    }

    public void openSource(String link) {
        HostServices hostServices = getHostServices();
        hostServices.showDocument(link);
    }

    public static void main(String[] args) {
        launch();
    }
}