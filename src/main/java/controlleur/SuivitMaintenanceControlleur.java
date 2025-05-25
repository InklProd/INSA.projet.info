package controlleur;

import javafx.scene.control.Button;
import model.FiabiliteManager;
import view.FiabilitéView;

import java.io.IOException;
import java.util.Map;

public class SuivitMaintenanceControlleur {
    private final FiabiliteManager fiabiliteManager;

    public SuivitMaintenanceControlleur() {
        this.fiabiliteManager = new FiabiliteManager();
    }

    public Button creerBoutonAfficherFiabilite() {
        Button btnFiabilite = new Button("Afficher Fiabilité");
        btnFiabilite.setOnAction(e -> {
            try {

                fiabiliteManager.chargerEvenements("suivi de maintenance.txt");
                Map<String, Float> fiabilites = fiabiliteManager.calculerFiabilites();
                FiabilitéView.afficher(fiabilites);
            } catch (IOException ex) {
                System.err.println("Erreur lors de la lecture du fichier : " + ex.getMessage());
            }
        });
        return btnFiabilite;
    }
}
