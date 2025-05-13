package controlleur;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.AtelierView;

public class OuvertureAtelier {

    private Button boutonAtelier;

    public OuvertureAtelier() {
        boutonAtelier = new Button("Ouvrir l'atelier");

        // Logique d'ouverture de la nouvelle fenêtre
        boutonAtelier.setOnAction(e -> {
            try {
                AtelierView atelier = new AtelierView();
                atelier.start(new Stage());
                
                Stage currentStage = (Stage) boutonAtelier.getScene().getWindow();
                currentStage.close();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public Button getBoutonAtelier() {
        return boutonAtelier;
    }
}

