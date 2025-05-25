package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Gamme;
import model.Equipement;

public class CreerOperationView extends Stage {
    private final TextField refOperationField = new TextField();
    private final TextField dOperationField = new TextField();
    private final ComboBox<String> refEquipementCombo = new ComboBox<>();
    private final TextField dureeOperationField = new TextField();
    private final Button validerBtn = new Button("Valider");

    public CreerOperationView(Gamme gamme) {
        setTitle("Créer une opération");
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().addAll(
            new Label("Référence opération :"), refOperationField,
            new Label("Description :"), dOperationField,
            new Label("Équipement associé :"), refEquipementCombo,
            new Label("Durée (heures) :"), dureeOperationField,
            validerBtn
        );
        for (Equipement eq : gamme.getListeEquipements()) {
            refEquipementCombo.getItems().add(eq.getRefEquipement());
        }
        setScene(new Scene(root, 300, 350));
        initModality(Modality.APPLICATION_MODAL);
    }

    public Button getValiderBtn() { return validerBtn; }
    public String getRefOperation() { return refOperationField.getText(); }
    public String getDOperation() { return dOperationField.getText(); }
    public String getRefEquipement() { return refEquipementCombo.getValue(); }
    public float getDureeOperation() {
        try { return Float.parseFloat(dureeOperationField.getText()); }
        catch (Exception e) { return 0f; }
    }
}
