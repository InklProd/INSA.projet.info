package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Equipement;
import model.Gamme;
import model.Atelier;

public class EquipementControlleur {
    private final Gamme gamme;
    private final ListView<Equipement> eqListView;

    public EquipementControlleur(Gamme gamme, ListView<Equipement> eqListView) {
        this.gamme = gamme;
        this.eqListView = eqListView;
    }

    public Button createDeleteButton(Equipement equipement) {
        Button deleteBtn = new Button("Supprimer");
        deleteBtn.setOnAction(e -> {
            eqListView.getItems().remove(equipement);
            gamme.getListeEquipements().remove(equipement);
        });
        return deleteBtn;
    }

    public void handleAjoutEquipement(Equipement addEquipementPlaceholder, Atelier atelier) {
        eqListView.setOnMouseClicked(event -> {
            Equipement selected = eqListView.getSelectionModel().getSelectedItem();
            if (selected == addEquipementPlaceholder) {
                view.SelectionEquipementView selectionView = new view.SelectionEquipementView(gamme, atelier, eqListView);
                selectionView.show();
            }
        });
    }

    public void handleSuppressionDepuisBouton(Button deleteBtn, Equipement addEquipementPlaceholder) {
        deleteBtn.setOnAction(e -> {
            Equipement selected = eqListView.getSelectionModel().getSelectedItem();
            if (selected != null && selected != addEquipementPlaceholder) {
                eqListView.getItems().remove(selected);
                gamme.getListeEquipements().remove(selected);
            }
        });
    }
}
