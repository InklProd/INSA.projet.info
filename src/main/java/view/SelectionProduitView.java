package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Gamme;
import model.Produit;
import java.util.ArrayList;

public class SelectionProduitView extends Stage {
    public SelectionProduitView(Gamme gamme, ListView<Produit> prodListView) {
        setTitle("Associer un produit existant");
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().add(new Label("Sélectionnez un produit à associer à la gamme :"));

        // Récupère tous les produits existants (hors déjà associés à la gamme)
        ArrayList<Produit> tousProduits = model.ProduitRepository.getAllProduits(); // À adapter selon ta gestion des produits
        ArrayList<Produit> nonAssocies = new ArrayList<>();
        for (Produit p : tousProduits) {
            if (!gamme.getProduitsFabriques().contains(p)) {
                nonAssocies.add(p);
            }
        }

        ListView<Produit> selectionListView = new ListView<>();
        selectionListView.getItems().addAll(nonAssocies);
        selectionListView.setCellFactory(param -> new ListCell<Produit>() {
            @Override
            protected void updateItem(Produit item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : (item.getCodeProduit() + " : " + item.getDProduit()));
            }
        });
        root.getChildren().add(selectionListView);

        Button associerBtn = new Button("Associer à la gamme");
        root.getChildren().add(associerBtn);
        associerBtn.setOnAction(e -> {
            Produit selected = selectionListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                gamme.ajouterProduit(selected);
                prodListView.getItems().add(selected);
                close();
            }
        });
        setScene(new Scene(root, 350, 400));
    }
}
