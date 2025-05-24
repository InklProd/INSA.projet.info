package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Operation;

public class ModifierOperationView extends Stage {
    private final TextField refOperationField;
    private final TextField dOperationField;
    private final TextField refEquipementField;
    private final TextField dureeOperationField;
    private final Button validerBtn;

    public ModifierOperationView(Operation operation) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().add(new Label("Modifier l'opération :"));

        refOperationField = new TextField(operation.getRefOperation());
        dOperationField = new TextField(operation.getDOperation());
        refEquipementField = new TextField(operation.getRefEquipement());
        dureeOperationField = new TextField(String.valueOf(operation.getDureeOperation()));

        root.getChildren().addAll(
            new Label("Référence :"), refOperationField,
            new Label("Description :"), dOperationField,
            new Label("Réf. équipement :"), refEquipementField,
            new Label("Durée :"), dureeOperationField
        );

        validerBtn = new Button("Valider");
        root.getChildren().add(validerBtn);

        this.setScene(new Scene(root, 300, 300));
        this.setTitle("Modifier une opération");
    }

    public Button getValiderBtn() { return validerBtn; }
    public String getRefOperation() { return refOperationField.getText(); }
    public String getDOperation() { return dOperationField.getText(); }
    public String getRefEquipement() { return refEquipementField.getText(); }
    public float getDureeOperation() {
        try { return Float.parseFloat(dureeOperationField.getText()); }
        catch (NumberFormatException e) { return 0f; }
    }
}
