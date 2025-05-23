package view;

import controlleur.BoutonMachineControlleur;
import controlleur.BoutonOperateurController;
import controlleur.BoutonPosteController;
import controlleur.CompetenceControlleur;
import controlleur.PosteOpListeView;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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

        // Bouton en haut à gauche
        Button btnListeGammes = new Button("Afficher la liste des gammes");
        btnListeGammes.setOnAction(e -> new ListeGammeView(atelier).show());
        HBox topBar = new HBox();
        topBar.setStyle("-fx-alignment: top-left; -fx-padding: 10;");
        topBar.getChildren().add(btnListeGammes);

        ListView<Object> listView = new ListView<>();
        ListView<String> machineListView = new ListView<>();
        machineListView.setPrefWidth(200);

        PosteOpListeView ListeObj = new PosteOpListeView(listView);
        ListeObj.setMachineListView(machineListView);

        // Zone d'action pour postes/opérateurs
        HBox zoneActionsPoste = new HBox(10);
        zoneActionsPoste.setStyle("-fx-padding: 10; -fx-alignment: center;");
        BoutonOperateurController boutonOperateur = new BoutonOperateurController(atelier, ListeObj, zoneActionsPoste);
        BoutonPosteController boutonPoste = new BoutonPosteController(atelier, ListeObj, zoneActionsPoste);
        boutonOperateur.setBoutonPoste(boutonPoste.getButton());
        boutonPoste.setBoutonOperateur(boutonOperateur.getButton());

        VBox vboxGauche = new VBox(10, ListeObj.getView(), zoneActionsPoste);
        vboxGauche.setStyle("-fx-alignment: center;");

        // Zone d'action pour machines
        HBox zoneActionsMachine = new HBox(10);
        zoneActionsMachine.setStyle("-fx-padding: 10; -fx-alignment: center;");
        Button creerMachineBtn = new Button("Créer machine");
        Button supprimerMachineBtn = new Button("Supprimer machine");
        zoneActionsMachine.getChildren().addAll(creerMachineBtn, supprimerMachineBtn);

        VBox vboxDroite = new VBox(10, machineListView, zoneActionsMachine);
        vboxDroite.setStyle("-fx-alignment: center;");
        vboxDroite.setVisible(false);
        vboxDroite.setManaged(false);

        BoutonMachineControlleur boutonMachine = new BoutonMachineControlleur(
            atelier, listView, creerMachineBtn, supprimerMachineBtn, machineListView
        );

        // Ajout du contrôleur de compétences
        CompetenceControlleur competenceControlleur = new CompetenceControlleur();
        VBox vboxCompetence = competenceControlleur.getView();
        vboxCompetence.setVisible(false);
        vboxCompetence.setManaged(false);

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            boolean isPoste = newVal instanceof Poste;
            boolean isOperateur = newVal instanceof Operateur;
            vboxDroite.setVisible(isPoste);
            vboxDroite.setManaged(isPoste);
            if (!isPoste) {
                machineListView.getItems().clear();
            }
            // Affichage dynamique de la zone compétence
            if (isOperateur) {
                competenceControlleur.setOperateur((Operateur) newVal);
            } else {
                competenceControlleur.setOperateur(null);
            }
        });

        HBox centre = new HBox(30, vboxGauche, vboxDroite, vboxCompetence);
        centre.setStyle("-fx-alignment: center;");

        HBox boutonsHaut = new HBox(10, boutonPoste.getButton(), boutonOperateur.getButton());
        boutonsHaut.setStyle("-fx-alignment: center;");

        VBox vbox = new VBox(10, topBar, label, boutonsHaut, centre);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        return vbox;
    }
}