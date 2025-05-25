package controlleur;

import model.Atelier;
import view.CreerEvenementMaintenance;

public class EventMaintenanceControlleur {
    private final Atelier atelier;

    public EventMaintenanceControlleur(Atelier atelier) {
        this.atelier = atelier;
    }

    public void lancerFenetreCreation() {
        CreerEvenementMaintenance creerEvenement = new CreerEvenementMaintenance(atelier);
        creerEvenement.afficherFenetre();
    }

    
}
