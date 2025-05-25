package view;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Machine;

import java.util.function.Consumer;

public class CreerMachineView extends Stage {
    public CreerMachineView(Consumer<Machine> onMachineCree) {
        setTitle("Créer une machine");

        TextField refField = new TextField();
        refField.setPromptText("Référence");

        TextField desField = new TextField();
        desField.setPromptText("Désignation");

        TextField typeField = new TextField();
        typeField.setPromptText("Type");

        TextField coutField = new TextField();
        coutField.setPromptText("Coût");

        TextField xField = new TextField();
        xField.setPromptText("Position X");

        TextField yField = new TextField();
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
                Machine machine = new Machine(ref, des, type, cout, x, y);
                onMachineCree.accept(machine);
                close();
            } catch (Exception ex) {}
        });

        VBox root = new VBox(10, refField, desField, typeField, coutField, xField, yField, valider);
        root.setStyle("-fx-padding: 20;");
        setScene(new Scene(root));
    }
}
