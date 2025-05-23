package view;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Machine;

import java.util.function.Consumer;

public class ModifierMachineView extends Stage {
    public ModifierMachineView(Machine machine, Consumer<Machine> onMachineModifiee) {
        setTitle("Modifier la machine");

        javafx.scene.control.Label refLabel = new javafx.scene.control.Label("Référence");
        TextField refField = new TextField(machine.getRefMachine());
        refField.setPromptText("Référence");

        javafx.scene.control.Label desLabel = new javafx.scene.control.Label("Désignation");
        TextField desField = new TextField(machine.getDMachine());
        desField.setPromptText("Désignation");

        javafx.scene.control.Label typeLabel = new javafx.scene.control.Label("Type");
        TextField typeField = new TextField(machine.getType());
        typeField.setPromptText("Type");

        javafx.scene.control.Label coutLabel = new javafx.scene.control.Label("Coût");
        TextField coutField = new TextField(String.valueOf(machine.getCout()));
        coutField.setPromptText("Coût");

        javafx.scene.control.Label xLabel = new javafx.scene.control.Label("Position X");
        TextField xField = new TextField(String.valueOf(machine.getX()));
        xField.setPromptText("Position X");

        javafx.scene.control.Label yLabel = new javafx.scene.control.Label("Position Y");
        TextField yField = new TextField(String.valueOf(machine.getY()));
        yField.setPromptText("Position Y");

        Button valider = new Button("Valider");

        valider.setOnAction(e -> {
            try {
                String ref = refField.getText();
                String des = desField.getText();
                String type = typeField.getText();
                float cout = Float.parseFloat(coutField.getText());
                float x = Float.parseFloat(xField.getText());
                float y = Float.parseFloat(yField.getText());
                // Utilisation des setters
                machine.setRefMachine(ref);
                machine.setDMachine(des);
                machine.setType(type);
                machine.setCout(cout);
                machine.setX(x);
                machine.setY(y);
                onMachineModifiee.accept(machine);
                close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox root = new VBox(8,
            refLabel, refField,
            desLabel, desField,
            typeLabel, typeField,
            coutLabel, coutField,
            xLabel, xField,
            yLabel, yField,
            valider
        );
        root.setStyle("-fx-padding: 20;");
        setScene(new Scene(root));
    }
}
