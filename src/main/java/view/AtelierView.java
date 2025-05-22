package view;

import controlleur.BoutonOperateurController;
import controlleur.BoutonPosteController;
import controlleur.PosteOpListeView;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Atelier;

public class AtelierView {
    public Parent getView() {
        Atelier atelier = new Atelier();

        Label label = new Label("Bienvenue dans l'atelier !");

        ListView<Object> listView = new ListView<>();
        ListView<String> machineListView = new ListView<>();
        machineListView.setPrefWidth(200);

        PosteOpListeView ListeObj = new PosteOpListeView(listView);
        ListeObj.setMachineListView(machineListView);

        HBox centre = ListeObj.getCenteredView();

        HBox zoneActions = new HBox(10);
        zoneActions.setStyle("-fx-padding: 10; -fx-alignment: center;");

        Button creerPosteBtn = new Button("Créer poste");
        Button supprimerPosteBtn = new Button("Supprimer poste");

        // Ajoute seulement les boutons poste
        zoneActions.getChildren().addAll(creerPosteBtn, supprimerPosteBtn);

        BoutonOperateurController boutonOperateur = new BoutonOperateurController(atelier, ListeObj, zoneActions);
        BoutonPosteController boutonPoste = new BoutonPosteController(atelier, ListeObj, zoneActions);

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
                centre,
                zoneActions
        );
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        return vbox;
    }
}