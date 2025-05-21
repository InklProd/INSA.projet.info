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

import java.util.function.Consumer;

public class CreerOperateurView extends Stage {
    public CreerOperateurView(Consumer<Operateur> onOperateurCree) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        Label labelCode = new Label("Code de l'opérateur :");
        TextField codeField = new TextField();
        codeField.setPromptText("Code");

        Label labelNom = new Label("Nom de l'opérateur :");
        TextField nomField = new TextField();
        nomField.setPromptText("Nom");

        Label labelPrenom = new Label("Prénom de l'opérateur :");
        TextField prenomField = new TextField();
        prenomField.setPromptText("Prénom");

        Button valider = new Button("Valider");

        valider.setOnAction(e -> {
            String code = codeField.getText();
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            if (!code.isEmpty() && !nom.isEmpty() && !prenom.isEmpty()) {
                Operateur nouvelOperateur = new Operateur(code, nom, prenom, new String[0]);
                onOperateurCree.accept(nouvelOperateur);
                this.close();
            } else {
                Alert alert = new Alert(AlertType.ERROR, "Veuillez remplir tous les champs.");
                alert.showAndWait();
            }
        });

        vbox.getChildren().addAll(labelCode, codeField, labelNom, nomField, labelPrenom, prenomField, valider);
        this.setScene(new Scene(vbox));
        this.setTitle("Créer un nouvel opérateur");
    }
}
