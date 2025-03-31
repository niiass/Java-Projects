package org.example.mcdonald.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import org.example.mcdonald.Utility;

public class OurServicesController {
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

    Utility utility = new Utility();

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