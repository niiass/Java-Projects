package org.example.mcdonald.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.example.mcdonald.Utility;
import org.example.mcdonald.models.Dao;
import org.example.mcdonald.ProductsDesign;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AboutUsController implements Initializable {
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
    private AnchorPane AboutUsPane = new AnchorPane();
    ProductsDesign productsDesign = new ProductsDesign();
    Dao dao = new Dao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AboutUsPane.getChildren().setAll(productsDesign.charityAnchorPane(dao.getCharity()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
}
