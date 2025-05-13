package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import model.Atelier;

public class BoutonPosteController {
    private final Button bouton;

    public BoutonPosteController(Atelier atelier, TextArea zoneAffichage) {
        bouton = new Button("Afficher les postes");

        bouton.setOnAction(e -> {
            StringBuilder sb = new StringBuilder("Postes disponibles :\n");
            atelier.getListePostes().forEach(p -> sb.append("- ").append(p).append("\n"));
            zoneAffichage.setText(sb.toString());
        });
    }

    public Button getButton() {
        return bouton;
    }
}