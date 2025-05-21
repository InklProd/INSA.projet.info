package view;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Operateur;

import java.util.List;
import java.util.function.Consumer;

public class SupprimerOperateurView extends Stage {
    public SupprimerOperateurView(List<Operateur> operateurs, Consumer<Operateur> onOperateurSupprime) {
        VBox vbox = new VBox(10);

        ListView<Operateur> listView = new ListView<>(FXCollections.observableArrayList(operateurs));
        Button supprimerBtn = new Button("Supprimer l'opérateur sélectionné");

        supprimerBtn.setOnAction(e -> {
            Operateur selection = listView.getSelectionModel().getSelectedItem();
            if (selection != null && onOperateurSupprime != null) {
                onOperateurSupprime.accept(selection);
                this.close();
            }
        });

        vbox.getChildren().addAll(listView, supprimerBtn);
        this.setScene(new Scene(vbox, 300, 400));
        this.setTitle("Supprimer un opérateur");
    }
}
