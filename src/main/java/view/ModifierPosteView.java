package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Poste;

public class ModifierPosteView extends Stage {
    public ModifierPosteView(Poste poste) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        Label labelRef = new Label("Référence du poste :");
        TextField refField = new TextField(poste != null ? poste.getRefPoste() : "");
        refField.setPromptText("Référence");

        Label labelDesc = new Label("Description du poste :");
        TextField descField = new TextField(poste != null ? poste.getDPoste() : "");
        descField.setPromptText("Description");

        Button valider = new Button("Valider");

        valider.setOnAction(e -> {
            String ref = refField.getText();
            String desc = descField.getText();
            if (!ref.isEmpty() && !desc.isEmpty()) {
                poste.setRefPoste(ref);
                poste.setDPoste(desc);
                this.close();
            } else {
                Alert alert = new Alert(AlertType.ERROR, "Veuillez remplir tous les champs.");
                alert.showAndWait();
            }
        });

        vbox.getChildren().addAll(labelRef, refField, labelDesc, descField, valider);
        this.setScene(new Scene(vbox, 300, 200));
        this.setTitle("Modifier un poste");
    }
}
