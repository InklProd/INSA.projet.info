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
                // Charger les événements depuis le fichier
                fiabiliteManager.chargerEvenements("suivi de maintenance.txt");

                // Calculer les fiabilités
                Map<String, Float> fiabilites = fiabiliteManager.calculerFiabilites();

                // Debug : afficher le contenu de la Map dans la console
                System.out.println("Fiabilités calculées : " + fiabilites);

                // Afficher les résultats dans une nouvelle fenêtre
                FiabilitéView.afficher(fiabilites);
            } catch (IOException ex) {
                System.err.println("Erreur lors de la lecture du fichier : " + ex.getMessage());
            }
        });
        return btnFiabilite;
    }
}
