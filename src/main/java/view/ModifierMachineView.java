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

        TextField desField = new TextField(machine.dMachine);
        desField.setPromptText("Désignation");

        TextField typeField = new TextField(machine.type);
        typeField.setPromptText("Type");

        TextField coutField = new TextField(String.valueOf(machine.getCout()));
        coutField.setPromptText("Coût");

        TextField xField = new TextField(String.valueOf(machine.x));
        xField.setPromptText("Position X");

        TextField yField = new TextField(String.valueOf(machine.y));
        yField.setPromptText("Position Y");

        Button valider = new Button("Valider");

        valider.setOnAction(e -> {
            try {
                String des = desField.getText();
                String type = typeField.getText();
                float cout = Float.parseFloat(coutField.getText());
                float x = Float.parseFloat(xField.getText());
                float y = Float.parseFloat(yField.getText());
                machine.modifierMachine(des, type, cout, x, y);
                onMachineModifiee.accept(machine);
                close();
            } catch (Exception ex) {
            }
        });

        VBox root = new VBox(10, desField, typeField, coutField, xField, yField, valider);
        root.setStyle("-fx-padding: 20;");
        setScene(new Scene(root));
    }
}
