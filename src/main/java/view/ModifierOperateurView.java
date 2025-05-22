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
import model.Operateur;

public class ModifierOperateurView extends Stage {
    public ModifierOperateurView(Operateur operateur) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        Label labelCode = new Label("Code de l'opérateur :");
        TextField codeField = new TextField(operateur != null ? operateur.toString().split(" - ")[0] : "");
        codeField.setPromptText("Code");

        Label labelNom = new Label("Nom de l'opérateur :");
        TextField nomField = new TextField(operateur != null ? operateur.toString().split(" - ")[1].split(" ")[0] : "");
        nomField.setPromptText("Nom");

        Label labelPrenom = new Label("Prénom de l'opérateur :");
        TextField prenomField = new TextField(operateur != null ? operateur.toString().split(" - ")[1].split(" ").length > 1 ? operateur.toString().split(" - ")[1].split(" ")[1] : "" : "");
        prenomField.setPromptText("Prénom");

        Button valider = new Button("Valider");

        valider.setOnAction(e -> {
            String code = codeField.getText();
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            if (!code.isEmpty() && !nom.isEmpty() && !prenom.isEmpty()) {
                try {
                    operateur.setCode(code);
                    operateur.setNom(nom);
                    operateur.setPrenom(prenom);
                } catch (Exception ex) {
                    new Alert(AlertType.ERROR, "Erreur lors de la modification.").showAndWait();
                }
                this.close();
            } else {
                Alert alert = new Alert(AlertType.ERROR, "Veuillez remplir tous les champs.");
                alert.showAndWait();
            }
        });

        vbox.getChildren().addAll(labelCode, codeField, labelNom, nomField, labelPrenom, prenomField, valider);
        this.setScene(new Scene(vbox, 300, 250));
        this.setTitle("Modifier un opérateur");
    }
}
