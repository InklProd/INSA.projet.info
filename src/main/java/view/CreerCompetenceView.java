package view;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.function.Consumer;

public class CreerCompetenceView extends Stage {
    public CreerCompetenceView(Consumer<String> onCompetenceCree) {
        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-padding: 10; -fx-alignment: center;");
        Label label = new Label("Nouvelle compétence :");
        TextField champ = new TextField();
        champ.setPromptText("Compétence");
        Button valider = new Button("Valider");
        valider.setOnAction(e -> {
            String competence = champ.getText();
            if (competence != null && !competence.trim().isEmpty()) {
                onCompetenceCree.accept(competence.trim());
                this.close();
            } else {
                new Alert(Alert.AlertType.ERROR, "Veuillez saisir une compétence.").showAndWait();
            }
        });
        vbox.getChildren().addAll(label, champ, valider);
        this.setScene(new Scene(vbox));
        this.setTitle("Créer une compétence");
        this.initModality(Modality.APPLICATION_MODAL);
    }
}
