package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Atelier;
import model.EvenementMaintenance;
import model.Machine;
import model.Operateur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CreerEvenementMaintenance {

    private final Atelier atelier;

    public CreerEvenementMaintenance(Atelier atelier) {
        this.atelier = atelier;
    }

    public void afficherFenetre() {
        Stage stage = new Stage();
        stage.setTitle("Créer un Événement Maintenance");

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Date/Heure
        Label lblDateHeure = new Label("Date/Heure:");
        DatePicker datePicker = new DatePicker();
        TextField timeField = new TextField();
        timeField.setPromptText("HH:mm"); // Indiquer le format attendu
        grid.add(lblDateHeure, 0, 0);
        grid.add(datePicker, 1, 0);
        grid.add(timeField, 2, 0);

        // Machine
        Label lblMachine = new Label("Machine:");
        ComboBox<Machine> machineComboBox = new ComboBox<>();
        machineComboBox.setPromptText("Sélectionnez une machine");
        machineComboBox.getItems().addAll(atelier.getAllMachines());
        grid.add(lblMachine, 0, 1);
        grid.add(machineComboBox, 1, 1);

        // Type d'événement
        Label lblTypeEvenement = new Label("Type d'Événement:");
        ComboBox<String> typeEvenementComboBox = new ComboBox<>();
        typeEvenementComboBox.getItems().addAll("A", "D");
        typeEvenementComboBox.setPromptText("Sélectionnez un type");
        grid.add(lblTypeEvenement, 0, 2);
        grid.add(typeEvenementComboBox, 1, 2);

        // Opérateur
        Label lblOperateur = new Label("Opérateur:");
        ComboBox<Operateur> operateurComboBox = new ComboBox<>();
        operateurComboBox.setPromptText("Sélectionnez un opérateur");
        operateurComboBox.getItems().addAll(atelier.getListeOperateurs());
        grid.add(lblOperateur, 0, 3);
        grid.add(operateurComboBox, 1, 3);

        // Cause
        Label lblCause = new Label("Cause:");
        TextArea causeArea = new TextArea();
        causeArea.setPromptText("Décrivez la cause de l'événement");
        causeArea.setPrefRowCount(3);
        grid.add(lblCause, 0, 4);
        grid.add(causeArea, 1, 4, 2, 1);

        // Bouton de validation
        Button btnValider = new Button("Créer");
        btnValider.setOnAction(e -> {
            try {
                // Valider et parser l'heure
                String timeText = timeField.getText();
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime time = LocalTime.parse(timeText, timeFormatter);

                // Récupérer la date
                LocalDate date = datePicker.getValue();
                if (date == null) {
                    throw new IllegalArgumentException("La date doit être sélectionnée.");
                }

                // Combiner la date et l'heure
                LocalDateTime dateHeure = LocalDateTime.of(date, time);

                // Récupérer les autres données
                Machine machine = machineComboBox.getValue();
                if (machine == null) {
                    throw new IllegalArgumentException("Une machine doit être sélectionnée.");
                }

                String typeEvenement = typeEvenementComboBox.getValue();
                if (typeEvenement == null) {
                    throw new IllegalArgumentException("Le type d'événement doit être sélectionné.");
                }

                Operateur operateur = operateurComboBox.getValue();
                if (operateur == null) {
                    throw new IllegalArgumentException("Un opérateur doit être sélectionné.");
                }

                String cause = causeArea.getText();
                if (cause.isEmpty()) {
                    throw new IllegalArgumentException("La cause doit être renseignée.");
                }

                // Créer l'événement maintenance
                EvenementMaintenance evenement = new EvenementMaintenance(dateHeure, machine, typeEvenement, operateur.getCode(), cause);

                // Ajouter l'événement au fichier texte
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("suivi de maintenance.txt", true))) {
                    // Formater la date et l'heure
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                    String dateFormattee = date.format(dateFormatter);
                    String heureFormattee = time.format(timeFormatter);

                    // Écrire dans le fichier selon la norme
                    writer.write(dateFormattee + ";" + heureFormattee + ";" + machine.getRefMachine() + ";" +
                                 typeEvenement + ";" + operateur.getCode() + ";" + cause);
                    writer.newLine();
                }

                // Fermer la fenêtre
                stage.close();
            } catch (DateTimeParseException ex) {
                System.err.println("Erreur : L'heure doit être au format HH:mm.");
            } catch (IllegalArgumentException ex) {
                System.err.println("Erreur : " + ex.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        grid.add(btnValider, 1, 5);

        // Scene
        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
