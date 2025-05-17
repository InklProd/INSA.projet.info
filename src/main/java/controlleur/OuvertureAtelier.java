package controlleur;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import view.AtelierView;

public class OuvertureAtelier {

    private Button boutonAtelier;

    public OuvertureAtelier() {
        boutonAtelier = new Button("Ouvrir l'atelier");

        boutonAtelier.setOnAction(e -> {
            try {
                Stage currentStage = (Stage) boutonAtelier.getScene().getWindow();
                AtelierView atelierView = new AtelierView();
                Scene scene = new Scene(atelierView.getView(), 700, 400);
                currentStage.setScene(scene);
                currentStage.setTitle("Atelier");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public Button getBoutonAtelier() {
        return boutonAtelier;
    }
}

