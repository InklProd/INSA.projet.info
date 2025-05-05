package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 *
 * @author batip
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // --- ÉCRAN TITRE ---
        Text titre = new Text("Bienvenue dans mon application !");
        Button boutonCommencer = new Button("Commencer");

        VBox ecranTitreLayout = new VBox(20, titre, boutonCommencer);
        ecranTitreLayout.setStyle("-fx-alignment: center; -fx-padding: 50;");
        Scene sceneTitre = new Scene(ecranTitreLayout, 400, 300);

        // --- ÉCRAN PRINCIPAL ---
        Text contenuPrincipal = new Text("Voici l'écran principal.");
        StackPane ecranPrincipalLayout = new StackPane(contenuPrincipal);
        Scene scenePrincipale = new Scene(ecranPrincipalLayout, 400, 300);

        // Changer de scène au clic sur le bouton
        boutonCommencer.setOnAction(e -> {
            primaryStage.setScene(scenePrincipale);
        });

        // Configuration de la fenêtre
        primaryStage.setTitle("Mon Application JavaFX");
        primaryStage.setScene(sceneTitre);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
