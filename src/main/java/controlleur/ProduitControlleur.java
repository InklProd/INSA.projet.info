package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Gamme;
import model.Produit;
import view.CreerProduitView;
import view.ModifierProduitView;
import view.SelectionProduitView;

public class ProduitControlleur {
    private final Gamme gamme;
    private final ListView<Produit> prodListView;
    private final Button creerProduitBtn;
    private final Button associerProduitBtn;
    private final Button supprimerProduitBtn;
    private final Stage parentStage;

    public ProduitControlleur(Gamme gamme, ListView<Produit> prodListView, Button creerProduitBtn, Button associerProduitBtn, Button supprimerProduitBtn, Stage parentStage) {
        this.gamme = gamme;
        this.prodListView = prodListView;
        this.creerProduitBtn = creerProduitBtn;
        this.associerProduitBtn = associerProduitBtn;
        this.supprimerProduitBtn = supprimerProduitBtn;
        this.parentStage = parentStage;
        initialiserActions();
    }

    private void initialiserActions() {
        creerProduitBtn.setOnAction(e -> ouvrirCreerProduit());
        associerProduitBtn.setOnAction(e -> ouvrirSelectionProduit());
        supprimerProduitBtn.setOnAction(e -> {
            Produit selected = prodListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                gamme.retirerProduit(selected);
                prodListView.getItems().remove(selected);
            }
        });
        prodListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Produit selected = prodListView.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    ModifierProduitView modifView = new ModifierProduitView(selected);
                    modifView.getValiderBtn().setOnAction(ev -> {
                        selected.modifierProduit(modifView.getCodeProduit(), modifView.getDesignation());
                        prodListView.refresh();
                        modifView.close();
                    });
                    modifView.initOwner(parentStage);
                    modifView.show();
                }
            }
        });
    }

    private void ouvrirCreerProduit() {
        CreerProduitView creerView = new CreerProduitView();
        creerView.getValiderBtn().setOnAction(ev -> {
            String code = creerView.getCodeProduit();
            String designation = creerView.getDesignation();
            if (!code.isEmpty() && !designation.isEmpty()) {
                Produit nouveau = new Produit(code, designation);
                gamme.ajouterProduit(nouveau);
                prodListView.getItems().add(nouveau);
                creerView.close();
            }
        });
        creerView.initOwner(parentStage);
        creerView.show();
    }

    private void ouvrirSelectionProduit() {
        SelectionProduitView selectionView = new SelectionProduitView(gamme, prodListView);
        selectionView.initOwner(parentStage);
        selectionView.show();
    }
}
