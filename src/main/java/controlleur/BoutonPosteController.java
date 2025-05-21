package controlleur;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import model.Atelier;
import view.CreerPosteView;
import view.SupprimerPosteView;

public class BoutonPosteController {
    private final Button bouton;
    private boolean actionsAjoutees = false;
    private Button boutonOperateur;
    private final ListView<Object> listView;
    private final Atelier atelier;

    public BoutonPosteController(Atelier atelier, ListView<Object> listView, HBox zoneAction) {
        this.atelier = atelier;
        this.listView = listView;
        bouton = new Button("Afficher les postes");

        bouton.setOnAction(e -> {
            afficherPostes();

            zoneAction.getChildren().clear();
            actionsAjoutees = false;

            if (!actionsAjoutees) {
                Button action1 = new Button("creer poste");
                Button action2 = new Button("suprimer poste");

                action1.setOnAction(ev -> {
                    CreerPosteView fenetre = new CreerPosteView(posteCree -> {
                        atelier.ajouterPoste(posteCree);
                        afficherPostes();
                    });
                    fenetre.show();
                });

                action2.setOnAction(ev -> {
                    SupprimerPosteView fenetreSuppr = new SupprimerPosteView(
                        atelier.getListePostes(),
                        posteASupprimer -> {
                            atelier.retirerPoste(posteASupprimer);
                            afficherPostes();
                        }
                    );
                    fenetreSuppr.show();
                });

                zoneAction.getChildren().addAll(action1, action2);
                actionsAjoutees = true;

                bouton.setDisable(true);
                if (boutonOperateur != null) boutonOperateur.setDisable(false);
            }
        });
    }

    private void afficherPostes() {
        listView.setItems(FXCollections.observableArrayList(atelier.getListePostes()));
    }

    public Button getButton() {
        return bouton;
    }

    public void setBoutonOperateur(Button boutonOperateur) {
        this.boutonOperateur = boutonOperateur;
    }
}