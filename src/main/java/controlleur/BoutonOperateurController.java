package controlleur;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import model.Atelier;
import model.Operateur;
import view.CreerOperateurView;

public class BoutonOperateurController {
    private final Button bouton;
    private boolean actionsAjoutees = false;
    private Button boutonPoste;
    private final PosteOpListeView listView;
    private final Atelier atelier;

    public BoutonOperateurController(Atelier atelier, PosteOpListeView listView, HBox zoneAction) {
        this.atelier = atelier;
        this.listView = listView;
        bouton = new Button("Afficher les opérateurs");

        bouton.setOnAction(e -> {
            afficherOperateurs();

            listView.hideMachineListView(); // <-- Ajoute ceci pour masquer la liste des machines

            zoneAction.getChildren().clear();
            actionsAjoutees = false;

            if (!actionsAjoutees) {
                Button action1 = new Button("créer opérateur");
                Button action2 = new Button("supprimer opérateur");

                action1.setOnAction(ev -> {
                    CreerOperateurView fenetre = new CreerOperateurView(operateurCree -> {
                        atelier.ajouterOperateur(operateurCree);
                        afficherOperateurs();
                    });
                    fenetre.show();
                });

                action2.setOnAction(ev -> {
                    Object operateurASupprimer = listView.getSelectedItem();
                    if (operateurASupprimer instanceof Operateur) {
                        atelier.retirerOperateur((Operateur) operateurASupprimer);
                        afficherOperateurs();
                    }
                });

                zoneAction.getChildren().addAll(action1, action2);
                actionsAjoutees = true;

                bouton.setDisable(true);
                if (boutonPoste != null) boutonPoste.setDisable(false);
            }
        });
    }

    private void afficherOperateurs() {
        listView.getView().setItems(FXCollections.observableArrayList(atelier.getListeOperateurs()));
    }

    public Button getButton() {
        return bouton;
    }

    public void setBoutonPoste(Button boutonPoste) {
        this.boutonPoste = boutonPoste;
    }
}