package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Accueil extends Application {

    @Override
    public void start(Stage stage) {
        Button startButton = new Button("Démarrer");

        startButton.setOnAction(e -> {
            // Ici, tu peux lancer une nouvelle scène ou autre partie du programme
            System.out.println("Lancement de la suite du programme...");
        });

        StackPane root = new StackPane(startButton);
        Scene scene = new Scene(root, 640, 480);

        stage.setTitle("Écran Titre");
        stage.setScene(scene);
        stage.show();
    }
}