package controlleur;

import javafx.application.Application;
import javafx.scene.control.Label;
import view.AtelierView;

public class AccueilController {

    private final Label messageLabel;

    public AccueilController(Label messageLabel) {
        this.messageLabel = messageLabel;
    }

    public void handleButtonClick() {
        System.out.println("Bouton cliqué !");
        
    }
}
