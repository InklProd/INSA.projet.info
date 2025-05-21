package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import model.Atelier;
import model.Operateur;

public class BoutonOperateurController {
    private final Button bouton;
    private Operateur operateur;
    private boolean actionsAjoutees = false;
    private Button boutonPoste; 

    public BoutonOperateurController(Atelier atelier, TextArea zoneAffichage, HBox zoneAction) { 
        bouton = new Button("Afficher les opérateurs");

        bouton.setOnAction(e -> {
            StringBuilder sb = new StringBuilder("Opérateurs disponibles :\n");
            atelier.getListeOperateurs().forEach(o -> sb.append("- ").append(o).append("\n"));
            zoneAffichage.setText(sb.toString());

            zoneAction.getChildren().clear();
            actionsAjoutees = false;

            if (!actionsAjoutees) {
                Button action1 = new Button("créer opérateur");
                Button action2 = new Button("supprimer opérateur");

                action1.setOnAction(ev -> atelier.ajouterOperateur(operateur));
                action2.setOnAction(ev -> atelier.retirerOperateur(operateur));

                zoneAction.getChildren().addAll(action1, action2);
                actionsAjoutees = true;

                bouton.setDisable(true);
                if (boutonPoste != null) boutonPoste.setDisable(false); 
            }
        });
    }

    public Button getButton() {
        return bouton;
    }

    public void setBoutonPoste(Button boutonPoste) {
        this.boutonPoste = boutonPoste;
    }
}