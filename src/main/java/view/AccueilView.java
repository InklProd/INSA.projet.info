package view;

import controlleur.AccueilController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccueilView extends Application {

    @Override
    public void start(Stage stage) {
        // UI elements
        Label messageLabel = new Label("Bienvenue dans le logiciel !");
        Button bouton = new Button("Commencer");

        // Contrôleur
        AccueilController controller = new AccueilController(messageLabel);

        // Bouton action
        bouton.setOnAction(e -> controller.handleButtonClick());

        // Mise en page
        VBox layout = new VBox(20);
        layout.setStyle("-fx-padding: 30; -fx-alignment: center;");
        layout.getChildren().addAll(messageLabel, bouton);

        // Scène
        Scene scene = new Scene(layout, 400, 200);

        // Stage
        stage.setTitle("Écran d'accueil");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}