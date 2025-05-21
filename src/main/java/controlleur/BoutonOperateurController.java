package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import model.Atelier;
import model.Operateur;
import view.CreerOperateurView;
import view.SupprimerOperateurView;

public class BoutonOperateurController {
    private final Button bouton;
    private Operateur operateur;
    private boolean actionsAjoutees = false;
    private Button boutonPoste; 

    public BoutonOperateurController(Atelier atelier, TextArea zoneAffichage, HBox zoneAction) { 
        bouton = new Button("Afficher les opérateurs");

        bouton.setOnAction(e -> {
            afficherOperateurs(atelier, zoneAffichage);

            zoneAction.getChildren().clear();
            actionsAjoutees = false;

            if (!actionsAjoutees) {
                Button action1 = new Button("créer opérateur");
                Button action2 = new Button("supprimer opérateur");

                action1.setOnAction(ev -> {
                    CreerOperateurView fenetre = new CreerOperateurView(operateurCree -> {
                        atelier.ajouterOperateur(operateurCree);
                        afficherOperateurs(atelier, zoneAffichage); 
                    });
                    fenetre.show();
                });

                action2.setOnAction(ev -> {
                    SupprimerOperateurView fenetreSuppr = new SupprimerOperateurView(
                        atelier.getListeOperateurs(),
                        operateurASupprimer -> {
                            atelier.retirerOperateur(operateurASupprimer);
                            afficherOperateurs(atelier, zoneAffichage);
                        }
                    );
                    fenetreSuppr.show();
                });

                zoneAction.getChildren().addAll(action1, action2);
                actionsAjoutees = true;

                bouton.setDisable(true);
                if (boutonPoste != null) boutonPoste.setDisable(false); 
            }
        });
    }

    private void afficherOperateurs(Atelier atelier, TextArea zoneAffichage) {
        StringBuilder sb = new StringBuilder("Opérateurs disponibles :\n");
        if (atelier.getListeOperateurs().isEmpty()) {
            sb.append("Aucun opérateur.\n");
        } else {
            atelier.getListeOperateurs().forEach(o -> sb.append("- ").append(o.toString()).append("\n"));
        }
        zoneAffichage.setText(sb.toString());
    }

    public Button getButton() {
        return bouton;
    }

    public void setBoutonPoste(Button boutonPoste) {
        this.boutonPoste = boutonPoste;
    }
}