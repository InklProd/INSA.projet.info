package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Poste;
import model.Atelier;
import model.Machine;
import view.CreerMachineView;
import view.ModifierMachineView;

public class BoutonMachineControlleur {
    public BoutonMachineControlleur(
        Atelier atelier,
        ListView<Object> posteListView,
        Button creerMachineBtn,
        Button supprimerMachineBtn,
        ListView<String> machineListView
    ) {
        creerMachineBtn.setOnAction(e -> {
            Object selected = posteListView.getSelectionModel().getSelectedItem();
            if (selected instanceof Poste) {
                Poste poste = (Poste) selected;
                CreerMachineView fenetre = new CreerMachineView(machineCree -> {
                    poste.ajouteMachine(machineCree);
                    machineListView.getItems().setAll(
                        poste.getListeMachines().stream().map(Object::toString).collect(java.util.stream.Collectors.toList())
                    );
                });
                fenetre.show();
            }
        });

        supprimerMachineBtn.setOnAction(e -> {
            Object selected = posteListView.getSelectionModel().getSelectedItem();
            if (selected instanceof Poste) {
                Poste poste = (Poste) selected;
                String machineStr = machineListView.getSelectionModel().getSelectedItem();
                if (machineStr != null) {
                    Machine machineASupprimer = poste.getListeMachines().stream()
                        .filter(m -> m.toString().equals(machineStr))
                        .findFirst().orElse(null);
                    if (machineASupprimer != null) {
                        poste.retireMachine(machineASupprimer);
                        machineListView.getItems().setAll(
                            poste.getListeMachines().stream().map(Object::toString).collect(java.util.stream.Collectors.toList())
                        );
                    }
                }
            }
        });

        machineListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Object posteSelected = posteListView.getSelectionModel().getSelectedItem();
                String machineStr = machineListView.getSelectionModel().getSelectedItem();
                if (posteSelected instanceof Poste && machineStr != null) {
                    Poste poste = (Poste) posteSelected;
                    Machine machine = poste.getListeMachines().stream()
                        .filter(m -> m.toString().equals(machineStr))
                        .findFirst().orElse(null);
                    if (machine != null) {
                        ModifierMachineView fenetre = new ModifierMachineView(machine, machineModifiee -> {
                            machineListView.getItems().setAll(
                                poste.getListeMachines().stream().map(Object::toString).collect(java.util.stream.Collectors.toList())
                            );
                        });
                        fenetre.show();
                    }
                }
            }
        });
    }
}
