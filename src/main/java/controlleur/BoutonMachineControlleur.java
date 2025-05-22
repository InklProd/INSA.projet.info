package controlleur;

import javafx.scene.control.Button;
import model.Atelier;
import model.Machine;
import model.Poste;
import view.CreerMachineView;

public class BoutonMachineControlleur {
    private final Button creerMachineBtn;
    private final Button supprimerMachineBtn;
    private final PosteOpListeView listView;
    private final Atelier atelier;

    public BoutonMachineControlleur(Atelier atelier, PosteOpListeView listView, Button creerMachineBtn, Button supprimerMachineBtn) {
        this.atelier = atelier;
        this.listView = listView;
        this.creerMachineBtn = creerMachineBtn;
        this.supprimerMachineBtn = supprimerMachineBtn;

        creerMachineBtn.setOnAction(e -> {
            Object selected = listView.getSelectedItem();
            if (selected instanceof Poste) {
                Poste poste = (Poste) selected;
                CreerMachineView fenetre = new CreerMachineView(machineCree -> {
                    poste.getListeMachines().add(machineCree);
                    listView.hideMachineListView();
                    listView.getView().getSelectionModel().select(selected); // Force le refresh
                });
                fenetre.show();
            }
        });

        supprimerMachineBtn.setOnAction(e -> {
            Object selected = listView.getSelectedItem();
            if (selected instanceof Poste) {
                Poste poste = (Poste) selected;
                String machineStr = listView.getMachineListView().getSelectionModel().getSelectedItem();
                if (machineStr != null) {
                    Machine machineASupprimer = poste.getListeMachines().stream()
                        .filter(m -> m.toString().equals(machineStr))
                        .findFirst().orElse(null);
                    if (machineASupprimer != null) {
                        poste.getListeMachines().remove(machineASupprimer);
                        listView.hideMachineListView();
                        listView.getView().getSelectionModel().select(selected); // Force le refresh
                    }
                }
            }
        });
    }
}
