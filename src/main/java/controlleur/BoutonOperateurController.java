package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import model.Atelier;

public class BoutonOperateurController {
    private final Button bouton;

    public BoutonOperateurController(Atelier atelier, TextArea zoneAffichage) {
        bouton = new Button("Afficher les opérateurs");
        bouton.setPrefSize(50,50);
        
        bouton.setOnAction(e -> {
            StringBuilder sb = new StringBuilder("Opérateurs disponibles :\n");
            atelier.getListeOperateurs().forEach(o -> sb.append("- ").append(o).append("\n"));
            zoneAffichage.setText(sb.toString());
        });
    }

    public Button getButton() {
        return bouton;
    }
}