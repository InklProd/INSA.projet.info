package view;

import controlleur.BoutonOperateurController;
import controlleur.BoutonPosteController;
import controlleur.CheckBoxControlleur;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Atelier;
import model.Operateur;
import model.Poste;

public class AtelierView {
    public Parent getView() {
        Atelier atelier = new Atelier();

        Label label = new Label("Bienvenue dans l'atelier !");

        // ListView commune pour opérateurs et postes
        ListView<Object> listView = new ListView<>();
        listView.setPrefHeight(150);
        listView.setCellFactory(list -> new CheckBoxControlleur());

        // Zone d'actions
        HBox zoneActions = new HBox(10);
        zoneActions.setStyle("-fx-padding: 10; -fx-alignment: center;");

        // Contrôleurs adaptés
        BoutonOperateurController boutonOperateur = new BoutonOperateurController(atelier, listView, zoneActions);
        BoutonPosteController boutonPoste = new BoutonPosteController(atelier, listView, zoneActions);

        boutonOperateur.setBoutonPoste(boutonPoste.getButton());
        boutonPoste.setBoutonOperateur(boutonOperateur.getButton());

        HBox boutonsHaut = new HBox(10,
                boutonPoste.getButton(),
                boutonOperateur.getButton()
        );
        boutonsHaut.setStyle("-fx-alignment: center;");

        VBox vbox = new VBox(10,
                label,
                boutonsHaut,
                listView,
                zoneActions
        );
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        return vbox;
    }
}