package com.example.dieze;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class HelloController {
    @FXML
    private Button connexionButton;

    @FXML
    private Text adresseMailText;

    @FXML
    private Text motDePasseText;

    @FXML
    private Button inscriptionButton;

    @FXML
    public void initialize() {
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/Gagalin-Regular.otf");
            Font customFont = Font.loadFont(is, 12);
            if (customFont == null) {
                System.out.println("Police non chargée");
            } else {
                connexionButton.setFont(customFont);
                adresseMailText.setFont(customFont);
                motDePasseText.setFont(customFont);
                inscriptionButton.setFont(customFont);
            }

            connexionButton.setOnAction(event -> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dieze/newWindow.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Dieze - Accueil");
                    stage.setScene(new Scene(root));
                    stage.show();

                    // Fermer la fenêtre actuelle
                    Stage currentStage = (Stage) connexionButton.getScene().getWindow();
                    currentStage.close();
                } catch (IOException e) {
                    System.out.println("Une erreur s'est produite lors du chargement du fichier FXML.");
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite dans la méthode initialize.");
            e.printStackTrace();
        }
    }
}