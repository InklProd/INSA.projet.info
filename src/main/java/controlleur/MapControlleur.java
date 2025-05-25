package controlleur;

import model.Atelier;
import view.Map;

public class MapControlleur {
    public void afficherCarte(Atelier atelier) {
        Map map = new Map();
        map.afficherCarte(atelier);
    }
}
