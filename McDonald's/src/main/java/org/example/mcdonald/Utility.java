package org.example.mcdonald;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class Utility {
    public void loadNewPage(Button hBoxButton, String fxmlLink) {
        hBoxButton.setOnMouseClicked(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlLink));
            try {
                Parent root = loader.load(); Stage stage = new Stage(); Scene scene = new Scene(root);
                stage.setScene(scene);
                Stage currentStage = (Stage) hBoxButton.getScene().getWindow();
                currentStage.close(); stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void contactSource(Hyperlink socialMedia, String url) {
        socialMedia.setOnMouseClicked(event -> {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
