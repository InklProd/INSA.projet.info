package view;

import controlleur.OuvertureAtelier;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccueilView extends Application {

    public void start(Stage primaryStage) {
        Label messageLabel = new Label("Prêt à gérer l'atelier ?");

        OuvertureAtelier controller = new OuvertureAtelier();

        VBox layout = new VBox(20);
        layout.setStyle("-fx-padding: 30; -fx-alignment: center;");
        layout.getChildren().addAll(messageLabel, controller.getBoutonAtelier());

        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setTitle("Écran d'accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}