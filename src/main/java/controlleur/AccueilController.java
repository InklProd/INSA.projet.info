package controlleur;

import javafx.scene.control.Label;

public class AccueilController {

    private final Label messageLabel;

    public AccueilController(Label messageLabel) {
        this.messageLabel = messageLabel;
    }

    public void handleButtonClick() {
        System.out.println("Bouton cliqué !");
        messageLabel.setText("Bon travail !");
    }
}
