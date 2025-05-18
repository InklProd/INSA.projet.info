package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Poste;

import java.util.function.Consumer;

public class CreerPosteView extends Stage {
    private final Consumer<Poste> onPosteCree;

    public CreerPosteView(Consumer<Poste> onPosteCree) {
        this.onPosteCree = onPosteCree;

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        Label labelRef = new Label("Référence du poste :");
        TextField refField = new TextField();
        refField.setPromptText("Référence");

        Label labelDesc = new Label("Description du poste :");
        TextField descField = new TextField();
        descField.setPromptText("Description");

        Button valider = new Button("Valider");

        valider.setOnAction(e -> {
            String ref = refField.getText();
            String desc = descField.getText();
            if (!ref.isEmpty() && !desc.isEmpty()) {
                Poste nouveauPoste = new Poste(ref, desc);
                if (onPosteCree != null) {
                    onPosteCree.accept(nouveauPoste);
                }
                this.close();
            }
        });

        vbox.getChildren().addAll(labelRef, refField, labelDesc, descField, valider);
        this.setScene(new Scene(vbox));
        this.setTitle("Créer un nouveau poste");
    }
}