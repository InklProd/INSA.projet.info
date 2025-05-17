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

    public BoutonPosteController(Atelier atelier, TextArea zoneAffichage, HBox zoneAction) { // Modifié ici
        bouton = new Button("Afficher les postes");

        bouton.setOnAction(e -> {
            StringBuilder sb = new StringBuilder("Postes disponibles :\n");
            atelier.getListePostes().forEach(p -> sb.append("- ").append(p).append("\n"));
            zoneAffichage.setText(sb.toString());
            
            if (!actionsAjoutees) {
                Button action1 = new Button("creer poste");
                Button action2 = new Button("suprimer poste");
                
                action1.setOnAction(ev -> atelier.ajouterPoste(poste));
                action2.setOnAction(ev -> atelier.retirerPoste(poste));
                
                zoneAction.getChildren().addAll(action1, action2);
                actionsAjoutees = true;

                bouton.setDisable(true);
            }
        });
    }

    public Button getButton() {
        return bouton;
    }
}