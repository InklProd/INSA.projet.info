package view;

import controlleur.BoutonOperateurController;
import controlleur.BoutonPosteController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Atelier;

public class AtelierView extends Application {
    public Atelier atelier;
    
    public void start(Stage stage) {
        Label label = new Label("Bienvenue dans l'atelier !");    
        TextArea zoneAffichage = new TextArea();
        zoneAffichage.setEditable(false);
        zoneAffichage.setPrefHeight(150);
        
        /*VBox zoneActions = new VBox(10);
        zoneActions.setStyle("-fx-padding: 10;");*/
        
        controlleur.BoutonPosteController boutonPoste = new BoutonPosteController(atelier, zoneAffichage/*, *zoneAction*/);
        controlleur.BoutonOperateurController boutonOperateur = new BoutonOperateurController(atelier, zoneAffichage/*, zoneAction*/);

        HBox layout = new HBox(200,
                boutonPoste.getButton(),
                boutonOperateur.getButton(),
                zoneAffichage
                //,zoneAction
        );
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        
        VBox vbox = new VBox(label, layout, zoneAffichage);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-padding: 500; -fx-alignment: center;");
        
        Scene scene = new Scene(vbox, 500, 500);
        stage.setTitle("Atelier");
        stage.setScene(scene);
        stage.show();
    }
}