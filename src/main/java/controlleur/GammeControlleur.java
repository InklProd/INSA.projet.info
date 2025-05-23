package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Atelier;
import model.Gamme;
import view.GammeView;

public class GammeControlleur {
    public GammeControlleur(Atelier atelier, ListView<Gamme> listView, Gamme addGammePlaceholder) {
        listView.setOnMouseClicked((MouseEvent event) -> {
            Gamme selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Stage parentStage = (Stage) listView.getScene().getWindow();
                if (selected == addGammePlaceholder) {
                    Gamme nouvelleGamme = new Gamme("");
                    atelier.ajouterGamme(nouvelleGamme);
                    listView.getItems().add(listView.getItems().size() - 1, nouvelleGamme);
                    listView.getSelectionModel().select(nouvelleGamme);
                    GammeView gammeView = new GammeView(nouvelleGamme, atelier);
                    gammeView.setOnShown(e -> parentStage.close());
                    gammeView.show();
                } else if (event.getClickCount() == 1) {
                    GammeView gammeView = new GammeView(selected, atelier);
                    gammeView.setOnShown(e -> parentStage.close());
                    gammeView.show();
                }
            }
        });
    }

    public GammeControlleur(Gamme gamme, TextField refField, Button validerBtn) {
        validerBtn.setOnAction(e -> {
            gamme.setRefGamme(refField.getText());
            // Rafraîchir le champ après modification
            refField.setText(gamme.getRefGamme());
        });
        // Rafraîchit automatiquement le champ si la valeur change ailleurs
        refField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.equals(gamme.getRefGamme())) {
                gamme.setRefGamme(newVal);
            }
        });
    }
}
