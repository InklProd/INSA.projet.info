package view;

import controlleur.GammeControlleur;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Atelier;
import model.Gamme;

public class ListeGammeView extends Stage {
    public ListeGammeView(Atelier atelier) {
        VBox root = new VBox(20);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().add(new Label("Liste des gammes :"));

        ListView<Gamme> listView = new ListView<>();
        listView.getItems().addAll(atelier.getListeGammes());
        // Ajout d'un élément spécial pour l'ajout
        Gamme addGammePlaceholder = new Gamme("+ Ajouter une nouvelle gamme");
        listView.getItems().add(addGammePlaceholder);
        listView.setCellFactory(param -> new ListCell<Gamme>() {
            @Override
            protected void updateItem(Gamme item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("");
                } else if (item == addGammePlaceholder) {
                    setText("+ Ajouter une nouvelle gamme");
                    setStyle("-fx-font-style: italic; color: #0078D7;");
                } else {
                    setText(item.getRefGamme());
                    setStyle("");
                }
            }
        });
        root.getChildren().add(listView);

        // Délègue les actions au contrôleur
        new GammeControlleur(atelier, listView, addGammePlaceholder);

        this.setScene(new Scene(root, 400, 400));
        this.setTitle("Liste des gammes");
    }
}
