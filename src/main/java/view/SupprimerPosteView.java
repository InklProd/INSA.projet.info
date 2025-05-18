package view;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Poste;

import java.util.List;
import java.util.function.Consumer;

public class SupprimerPosteView extends Stage {
    public SupprimerPosteView(List<Poste> postes, Consumer<Poste> onPosteSupprime) {
        VBox vbox = new VBox(10);

        ListView<Poste> listView = new ListView<>(FXCollections.observableArrayList(postes));
        Button supprimerBtn = new Button("Supprimer le poste sélectionné");

        supprimerBtn.setOnAction(e -> {
            Poste selection = listView.getSelectionModel().getSelectedItem();
            if (selection != null && onPosteSupprime != null) {
                onPosteSupprime.accept(selection);
                this.close();
            }
        });

        vbox.getChildren().addAll(listView, supprimerBtn);
        this.setScene(new Scene(vbox, 300, 400));
        this.setTitle("Supprimer un poste");
    }
}
