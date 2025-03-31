package org.example.mcdonald.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.example.mcdonald.models.Dao;
import org.example.mcdonald.Utility;
import org.example.mcdonald.ProductsDesign;

import java.sql.SQLException;

public class ProductsController {
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
    private AnchorPane NewAnchorPane = new AnchorPane();
    ProductsDesign productsDesign = new ProductsDesign();
    Dao dao = new Dao();
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
    public void NewRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("News")));
    }

    @FXML
    public void SandwichRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("Sandwiches")));
    }

    @FXML
    public void RollRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("Rolls & Salads")));
    }

    @FXML
    public void FriesRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("Fries & Starters")));
    }

    @FXML
    public void SauceRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("Sauces")));
    }

    @FXML
    public void DrinkRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("McCafe Drinks")));
    }

    @FXML
    public void ColdDrinkRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("Cold Drinks")));
    }

    @FXML
    public void ColdDessertRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("Desserts")));
    }

    @FXML
    public void HappyMealRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("Happy Meal")));
    }

    @FXML
    public void McMenuRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("McMenu")));
    }

    @FXML
    public void McDessertRadioSelected() throws SQLException {
        NewAnchorPane.getChildren().clear();
        NewAnchorPane.getChildren().add(productsDesign.newAnchorPane(dao.getByType("McCafe Desserts")));
    }
}
