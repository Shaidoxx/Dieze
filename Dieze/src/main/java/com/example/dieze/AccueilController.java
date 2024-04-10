package com.example.dieze;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class AccueilController {

@FXML
private ImageView rechercheImageView;

@FXML
private Button comptebutton;

@FXML
private Text adresseMailText;

@FXML
private Button accueilbutton;

@FXML
private Button recherchebutton;

@FXML
public void initialize() {
    try {
        InputStream is = getClass().getResourceAsStream("/fonts/Gagalin-Regular.otf");
        Font customFont = Font.loadFont(is, 12);
        if (customFont == null) {
            System.out.println("Police non chargée");
        } else {
            recherchebutton.setFont(customFont);
            accueilbutton.setFont(customFont);
            recherchebutton.setFont(customFont);
            accueilbutton.setFont(customFont);
        }

        rechercheImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dieze/recherche.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                // Fermer la fenêtre actuelle
                Stage currentStage = (Stage) rechercheImageView.getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        comptebutton.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dieze/compte.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                // Fermer la fenêtre actuelle
                Stage currentStage = (Stage) comptebutton.getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        accueilbutton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dieze/accueil.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                // Fermer la fenêtre actuelle
                Stage currentStage = (Stage) accueilbutton.getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}