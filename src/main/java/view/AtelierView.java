package view;

import controlleur.BoutonOperateurController;
import controlleur.BoutonPosteController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Atelier;

public class AtelierView extends Application {

    public void start(Stage stage) {
        Label label = new Label("Bienvenue dans l'atelier !");
        StackPane root = new StackPane(label);
        root.setStyle("-fx-padding: 20;");
        
        TextArea zoneAffichage = new TextArea();
        zoneAffichage.setEditable(false);
        zoneAffichage.setPrefHeight(150);
        
        controlleur.BoutonPosteController boutonPoste = new BoutonPosteController(Atelier, zoneAffichage);
        controlleur.BoutonOperateurController boutonOperateur = new BoutonOperateurController(Atelier, zoneAffichage);

        VBox layout = new VBox(15,
                boutonPoste.getButton(),
                boutonOperateur.getButton(),
                zoneAffichage
        );
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 150);
        stage.setTitle("Atelier");
        stage.setScene(scene);
        stage.show();
    }
}