package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Gamme;
import model.Equipement;
import model.Operation;
import controlleur.GammeControlleur;
import model.Atelier;
import controlleur.EquipementControlleur;
import model.Produit;;

public class GammeView extends Stage {
    public GammeView(Gamme gamme, Atelier atelier) {
        VBox root = new VBox(20);
        root.setStyle("-fx-padding: 20;");

        // Champ modifiable pour la référence de la gamme + bouton de validation à côté
        HBox refBox = new HBox(10);
        refBox.getChildren().add(new Label("Référence de la gamme :"));
        TextField refField = new TextField(gamme.getRefGamme());
        Button validerBtn = new Button("Valider");
        refBox.getChildren().addAll(refField, validerBtn);
        root.getChildren().add(refBox);

        // Liste des équipements
        VBox eqBox = new VBox(5);
        eqBox.getChildren().add(new Label("Liste des équipements :"));
        ListView<Equipement> eqListView = new ListView<>();
        eqListView.getItems().addAll(gamme.getListeEquipements());
        EquipementControlleur equipementControlleur = new EquipementControlleur(gamme, eqListView);
        eqListView.setCellFactory(param -> new ListCell<Equipement>() {
            protected void updateItem(Equipement item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else if (item.getRefEquipement().equals("+ Ajouter un équipement")) {
                    setText(item.getRefEquipement());
                    setGraphic(null);
                } else {
                    setText(item.getRefEquipement() + " : " + item.getDEquipement());
                    setGraphic(null);
                }
            }
        });
        // Élément spécial pour ajouter un équipement
        Equipement addEquipementPlaceholder = new Equipement("+ Ajouter un équipement", "");
        eqListView.getItems().add(addEquipementPlaceholder);
        eqBox.getChildren().add(eqListView);
        // Bouton de suppression global sous la ListView
        Button deleteBtn = new Button("Supprimer l'équipement sélectionné");
        eqBox.getChildren().add(deleteBtn);
        root.getChildren().add(eqBox);
        // Action d'ajout d'équipement déléguée au contrôleur
        equipementControlleur.handleAjoutEquipement(addEquipementPlaceholder, atelier);
        // Action de suppression déléguée au contrôleur
        equipementControlleur.handleSuppressionDepuisBouton(deleteBtn, addEquipementPlaceholder);

        // Liste des opérations
        VBox opBox = new VBox(5);
        opBox.getChildren().add(new Label("Liste des opérations :"));
        ListView<Operation> opListView = new ListView<>();
        opListView.getItems().addAll(gamme.getListeOperations());
        // Élément spécial pour ajouter une opération
        Operation addOperationPlaceholder = new Operation("+ Ajouter une opération", "", "", 0f);
        opListView.getItems().add(addOperationPlaceholder);
        opBox.getChildren().add(opListView);
        // Bouton de suppression global sous la ListView des opérations
        Button deleteOpBtn = new Button("Supprimer l'opération sélectionnée");
        opBox.getChildren().add(deleteOpBtn);
        root.getChildren().add(opBox);
        // Contrôleur pour l'ajout et la modification d'opération (clic/double-clic)
        controlleur.OperationControlleur operationControlleur = new controlleur.OperationControlleur(gamme, opListView);
        operationControlleur.handleListViewActions(addOperationPlaceholder);
        // Action de suppression déléguée au contrôleur
        operationControlleur.handleSuppressionDepuisBouton(deleteOpBtn, addOperationPlaceholder);

        // Liste des produits fabriqués par la gamme
        VBox prodBox = new VBox(5);
        prodBox.getChildren().add(new Label("Produits fabriqués par cette gamme :"));
        ListView<Produit> prodListView = new ListView<>();
        prodListView.getItems().addAll(gamme.getProduitsFabriques());
        prodListView.setCellFactory(param -> new ListCell<Produit>() {
            @Override
            protected void updateItem(Produit item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getCodeProduit() + " : " + item.getDProduit());
                }
            }
        });
        prodBox.getChildren().add(prodListView);
        Button creerProduitBtn = new Button("Créer un produit");
        Button associerProduitBtn = new Button("Associer un produit existant");
        Button supprimerProduitBtn = new Button("Supprimer le produit sélectionné");
        prodBox.getChildren().addAll(creerProduitBtn, associerProduitBtn, supprimerProduitBtn);
        root.getChildren().add(prodBox);
        // Contrôleur dédié pour la gestion des produits
        new controlleur.ProduitControlleur(gamme, prodListView, creerProduitBtn, associerProduitBtn, supprimerProduitBtn, this);

        // Contrôleur pour la validation
        new GammeControlleur(gamme, refField, validerBtn);

        this.setScene(new Scene(root, 400, 400));
        this.setTitle("Affichage d'une gamme");
        this.setX(0);
        this.setY(0);
    }
}
