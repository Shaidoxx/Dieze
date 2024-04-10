package com.example.dieze;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class AdminController {

    @FXML
    private ImageView rechercheImageView;

    @FXML
    public void initialize() {
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/Gagalin-Regular.otf");
            Font customFont = Font.loadFont(is, 12);
            if (customFont == null) {
                System.out.println("Police non chargée");
            }

            rechercheImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> openNewPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openNewPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dieze/admin.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}