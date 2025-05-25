package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Atelier;
import model.Equipement;
import model.Gamme;
import model.Machine;
import model.Poste;

import java.util.ArrayList;

public class SelectionEquipementView extends Stage {
    public SelectionEquipementView(Gamme gamme, Atelier atelier, ListView<Equipement> eqListView) {
        setTitle("Sélectionner un équipement à ajouter");
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().add(new Label("Sélectionnez un équipement à ajouter à la gamme :"));

        // Récupère tous les équipements des postes et machines de l'atelier
        ArrayList<Equipement> equipements = new ArrayList<>();
        if (atelier != null) {
            for (Poste poste : atelier.getListePostes()) {
                equipements.add(poste);
                for (Machine machine : poste.getListeMachines()) {
                    equipements.add(machine);
                }
            }
        }

        ListView<Equipement> equipementListView = new ListView<>();
        equipementListView.getItems().addAll(equipements);
        equipementListView.setCellFactory(param -> new ListCell<Equipement>() {
            protected void updateItem(Equipement item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : (item.getRefEquipement() + " : " + item.getDEquipement()));
            }
        });
        root.getChildren().add(equipementListView);

        Button ajouterBtn = new Button("Ajouter à la gamme");
        root.getChildren().add(ajouterBtn);

        ajouterBtn.setOnAction(e -> {
            Equipement selected = equipementListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                String type = "";
                if (selected instanceof Poste) {
                    type = " (Poste)";
                } else if (selected instanceof Machine) {
                    type = " (Machine)";
                }
                gamme.getListeEquipements().add(selected);
                // Met à jour la ListView de la vue principale avec indication du type
                eqListView.getItems().add(eqListView.getItems().size() - 1, selected);
                // Suppression de la notification d'ajout d'équipement
                close();
            }
        });

        setScene(new Scene(root, 350, 400));
    }
}
