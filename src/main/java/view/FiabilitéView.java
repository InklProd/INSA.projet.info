package view;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.Map;

public class FiabilitéView {
    public static void afficher(Map<String, Float> fiabilites) {
        Stage stage = new Stage();
        stage.setTitle("Classement des Fiabilités");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        StringBuilder content = new StringBuilder("=== Classement des Fiabilités ===\n");
        fiabilites.entrySet().stream()
            .sorted(Map.Entry.<String, Float>comparingByValue().reversed())
            .forEach(entry -> content.append("Machine: ").append(entry.getKey())
                    .append(" | Fiabilité: ").append(String.format("%.2f", entry.getValue())).append("\n"));

        textArea.setText(content.toString());

        Scene scene = new Scene(textArea, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}