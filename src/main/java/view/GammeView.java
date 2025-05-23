package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Gamme;
import model.Equipement;
import model.Operation;
import controlleur.GammeControlleur;

public class GammeView extends Stage {
    public GammeView(Gamme gamme) {
        VBox root = new VBox(20);
        root.setStyle("-fx-padding: 20;");

        // Champ modifiable pour la référence de la gamme + bouton de validation à côté
        HBox refBox = new HBox(10);
        refBox.getChildren().add(new Label("Référence de la gamme :"));
        TextField refField = new TextField(gamme.getRefGamme());
        Button validerBtn = new Button("Valider");
        refBox.getChildren().addAll(refField, validerBtn);
        root.getChildren().add(refBox);

        // Liste des opérations
        VBox opBox = new VBox(5);
        opBox.getChildren().add(new Label("Liste des opérations :"));
        ListView<Operation> opListView = new ListView<>();
        opListView.getItems().addAll(gamme.getListeOperations());
        opBox.getChildren().add(opListView);
        root.getChildren().add(opBox);

        // Liste des équipements
        VBox eqBox = new VBox(5);
        eqBox.getChildren().add(new Label("Liste des équipements :"));
        ListView<Equipement> eqListView = new ListView<>();
        eqListView.getItems().addAll(gamme.getListeEquipements());
        eqListView.setCellFactory(param -> new ListCell<Equipement>() {
            @Override
            protected void updateItem(Equipement item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : (item.getRefEquipement() + " : " + item.getDEquipement()));
            }
        });
        eqBox.getChildren().add(eqListView);
        root.getChildren().add(eqBox);

        // Contrôleur pour la validation
        new GammeControlleur(gamme, refField, validerBtn);

        this.setScene(new Scene(root, 400, 400));
        this.setTitle("Affichage d'une gamme");
        this.setX(0);
        this.setY(0);
    }
}
