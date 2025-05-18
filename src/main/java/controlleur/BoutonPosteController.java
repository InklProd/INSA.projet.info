package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import model.Atelier;
import model.Poste;

public class BoutonPosteController {
    private final Button bouton;
    private Poste poste;
    private boolean actionsAjoutees = false;
    private Button boutonOperateur; // Ajoute cette ligne

    public BoutonPosteController(Atelier atelier, TextArea zoneAffichage, HBox zoneAction) { // Modifié ici
        bouton = new Button("Afficher les postes");

        bouton.setOnAction(e -> {
            StringBuilder sb = new StringBuilder("Postes disponibles :\n");
            atelier.getListePostes().forEach(p -> sb.append("- ").append(p).append("\n"));
            zoneAffichage.setText(sb.toString());
            
            zoneAction.getChildren().clear();
            actionsAjoutees = false;

            if (!actionsAjoutees) {
                Button action1 = new Button("creer poste");
                Button action2 = new Button("suprimer poste");
                
                action1.setOnAction(ev -> atelier.ajouterPoste(poste));
                action2.setOnAction(ev -> atelier.retirerPoste(poste));
                
                zoneAction.getChildren().addAll(action1, action2);
                actionsAjoutees = true;

                bouton.setDisable(true);
                if (boutonOperateur != null) boutonOperateur.setDisable(false); // Active l'autre bouton
            }
        });
    }

    public Button getButton() {
        return bouton;
    }

    public void setBoutonOperateur(Button boutonOperateur) {
        this.boutonOperateur = boutonOperateur;
    }
}