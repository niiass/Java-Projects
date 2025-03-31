package org.example.mcdonald.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.example.mcdonald.Utility;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ImageView imageView;
    @FXML
    private Button ourProducts;
    @FXML
    private Button aboutUs;
    @FXML
    private Button mcCafe;
    @FXML
    private Button ourServices;
    @FXML
    private Button family;
    @FXML
    private Hyperlink McFacebook;
    @FXML
    private Hyperlink McInstagram;
    @FXML
    private Hyperlink McLinkedIn;
    @FXML
    private Hyperlink McYouTube;
    int count = 0;
    Utility utility = new Utility();

    @FXML
    public void slideShow() throws SQLException {
        List<Image> images = new ArrayList<Image>();
        try {
            images.add(new Image(getClass().getResource("/photos/Slide2.png").toExternalForm()));
            images.add(new Image(getClass().getResource("/photos/Slide3.png").toExternalForm()));
            images.add(new Image(getClass().getResource("/photos/Slide1.png").toExternalForm()));
        } catch (NullPointerException nullPointerException) {
            System.out.println("Invalid slide photos url.");
        }
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            try {
                imageView.setImage(images.get(count));
                count++;
                if (count == 3) {
                    count = 0;
                }
            } catch (NullPointerException e) { System.out.println("Null Pointer Exception"); }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            slideShow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ourProductsFunc() {
        utility.loadNewPage(ourProducts, "ProductsPage.fxml");
    }

    public void aboutUsFunc() {
        utility.loadNewPage(aboutUs, "AboutUsPage.fxml");
    }

    public void ourServicesFunc() {
        utility.loadNewPage(ourServices, "OurServicesPage.fxml");
    }

    public void familyFunc() {
        utility.loadNewPage(family, "FamilyPage.fxml");
    }

    public void mcCafeFunc() {
        utility.loadNewPage(mcCafe, "McCafePage.fxml");
    }

    @FXML
    private void openMcFacebook() {
        utility.contactSource(McFacebook, "https://www.facebook.com/McDonaldsGeo");
    }

    @FXML
    private void openMcInstagram() {
        utility.contactSource(McInstagram, "https://www.instagram.com/mcdonalds_geo/");
    }

    @FXML
    private void openMcLinkedIn() {
        utility.contactSource(McLinkedIn, "https://www.linkedin.com/company/mcdonalds-georgia/");
    }

    @FXML
    private void openMcYouTube() {
        utility.contactSource(McYouTube, "https://www.youtube.com/channel/UCz_HKVYbEHtEg62yIwQwiAA");
    }
}
