package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreerProduitView extends Stage {
    private final TextField codeField;
    private final TextField designationField;
    private final Button validerBtn;

    public CreerProduitView() {
        setTitle("Créer un produit");
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().add(new Label("Code produit :"));
        codeField = new TextField();
        root.getChildren().add(codeField);
        root.getChildren().add(new Label("Désignation :"));
        designationField = new TextField();
        root.getChildren().add(designationField);
        validerBtn = new Button("Valider");
        root.getChildren().add(validerBtn);
        setScene(new Scene(root, 300, 200));
    }

    public Button getValiderBtn() { return validerBtn; }
    public String getCodeProduit() { return codeField.getText(); }
    public String getDesignation() { return designationField.getText(); }
}
