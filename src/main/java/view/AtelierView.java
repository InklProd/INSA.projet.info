package view;

import controlleur.BoutonOperateurController;
import controlleur.BoutonPosteController;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Atelier;

public class AtelierView {
    public Parent getView() {
        Atelier atelier = new Atelier();

        Label label = new Label("Bienvenue dans l'atelier !");
        TextArea zoneAffichage = new TextArea();
        zoneAffichage.setEditable(false);
        zoneAffichage.setPrefHeight(150);

        HBox zoneActions = new HBox(10);
        zoneActions.setStyle("-fx-padding: 10; -fx-alignment: center;");

        BoutonOperateurController boutonOperateur = new BoutonOperateurController(atelier, zoneAffichage, zoneActions);
        BoutonPosteController boutonPoste = new BoutonPosteController(atelier, zoneAffichage, zoneActions);

        boutonOperateur.setBoutonPoste(boutonPoste.getButton());
        boutonPoste.setBoutonOperateur(boutonOperateur.getButton());

        HBox boutonsHaut = new HBox(10,
                boutonPoste != null ? boutonPoste.getButton() : new Label("Erreur bouton poste"),
                boutonOperateur != null ? boutonOperateur.getButton() : new Label("Erreur bouton opérateur")
        );
        boutonsHaut.setStyle("-fx-alignment: center;");

        VBox vbox = new VBox(10,
                label,
                boutonsHaut,
                zoneAffichage,
                zoneActions
        );
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        return vbox;
    }
}