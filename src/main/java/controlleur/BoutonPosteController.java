package controlleur;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import model.Atelier;
import model.Poste;
import view.CreerPosteView;

public class BoutonPosteController {
    private final Button bouton;
    private boolean actionsAjoutees = false;
    private Button boutonOperateur;
    private final PosteOpListeView listView;
    private final Atelier atelier;

    public BoutonPosteController(Atelier atelier, PosteOpListeView listView, HBox zoneAction) {
        this.atelier = atelier;
        this.listView = listView;
        bouton = new Button("Afficher les postes");

        bouton.setOnAction(e -> {
            afficherPostes();

            zoneAction.getChildren().clear();
            actionsAjoutees = false;

            if (!actionsAjoutees) {
                Button action1 = new Button("Créer poste");
                Button action2 = new Button("Supprimer poste");

                action1.setOnAction(ev -> {
                    CreerPosteView fenetre = new CreerPosteView(posteCree -> {
                        atelier.ajouterPoste(posteCree);
                        afficherPostes();
                    });
                    fenetre.show();
                });

                action2.setOnAction(ev -> {
                    Object posteASupprimer = listView.getSelectedItem();
                    if (posteASupprimer instanceof Poste) {
                        atelier.retirerPoste((Poste) posteASupprimer);
                        afficherPostes();
                    }
                });

                zoneAction.getChildren().addAll(action1, action2);
                actionsAjoutees = true;

                bouton.setDisable(true);
                if (boutonOperateur != null) boutonOperateur.setDisable(false);
            }
        });
    }

    private void afficherPostes() {
        listView.getView().setItems(FXCollections.observableArrayList(atelier.getListePostes()));
    }

    public Button getButton() {
        return bouton;
    }

    public void setBoutonOperateur(Button boutonOperateur) {
        this.boutonOperateur = boutonOperateur;
    }
}