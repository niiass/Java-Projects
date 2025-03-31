package org.example.mcdonald;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.mcdonald.models.Charity;
import org.example.mcdonald.models.Products;

import java.util.List;

public class ProductsDesign {
    public AnchorPane newAnchorPane(List<Products> products) {
        AnchorPane anchorPane = new AnchorPane();

        double xCoordinate = 25.0; double yCoordinate = 15.0;

        for (int i = 0; i < products.size(); i++) {
            // PRODUCT DATA
            Rectangle rectangle = new Rectangle();
            rectangle.setHeight(245.0);  rectangle.setWidth(225.0);
            rectangle.setX(xCoordinate); rectangle.setY(yCoordinate);
            // IMAGE
            ImageView imageView = new ImageView(products.get(i).getImg());
            imageView.setFitHeight(180); imageView.setFitWidth(225);
            imageView.setX(xCoordinate); imageView.setY(yCoordinate);
            // NAME BUTTON
            Button button = new Button(products.get(i).getName());
            button.setPrefHeight(75); button.setPrefWidth(225);
            button.setLayoutX(xCoordinate); button.setLayoutY(yCoordinate+170);
            button.setFont(Font.font("LeeLawadee UI", FontWeight.BOLD, 15));
            button.setWrapText(true);

            anchorPane.getChildren().add(rectangle);
            anchorPane.getChildren().add(imageView);
            anchorPane.getChildren().add(button);
            button.setStyle("-fx-background-color: #FFC72C; -fx-border-color: #B2BEB5;");
            rectangle.setStyle("-fx-background-color: white; -fx-border-color: #B2BEB5;");

            if ((i + 1) % 2 == 0) {
                xCoordinate = 25.0;
                yCoordinate += 260.0;
            } else {
                xCoordinate = 270.0;
            }
        }


        return anchorPane;
    }


    public AnchorPane charityAnchorPane(List<Charity> charities) {
        AnchorPane anchorPane = new AnchorPane();

        double xCoordinate = 210; double yCoordinate = 0;

        for (int i = 0; i < charities.size(); i++) {
            // LABEL
            Label label = new Label(charities.get(charities.size()-i-1).getYear().toString());
            label.setPrefHeight(30); label.setPrefWidth(350);
            label.setLayoutX(xCoordinate-140); label.setLayoutY(yCoordinate);
            label.setFont(Font.font("LeeLawadee UI", FontWeight.BOLD, 20));
            // IMAGE
            ImageView imageView = new ImageView(charities.get(charities.size()-i-1).getImage());
            imageView.setFitHeight(179); imageView.setFitWidth(350);
            imageView.setX(xCoordinate-140); imageView.setY(yCoordinate+30);
            // DESCRIPTION
            Label text = new Label(charities.get(charities.size()-i-1).getDescription());
            text.setFont(Font.font("LeeLawadee UI", 13));
            text.setLayoutX(xCoordinate-140); text.setLayoutY(yCoordinate+210);
            text.setPrefHeight(130); text.setPrefWidth(350); text.setWrapText(true);

            anchorPane.getChildren().add(label);
            anchorPane.getChildren().add(imageView);
            anchorPane.getChildren().add(text);
            label.setStyle("-fx-background-color: #DA291C; -fx-text-alignment: center;");
            text.setStyle("-fx-background-color: white;");

            if ((i + 1) % 2 == 0) {
                xCoordinate = 210;
                yCoordinate += 360;
            } else {
                xCoordinate = 570;
            }
        }

        return anchorPane;
    }
}
