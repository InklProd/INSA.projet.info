package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Gamme;
import model.Operation;
import view.CreerOperationView;

public class OperationControlleur {
    private final Gamme gamme;
    private final ListView<Operation> opListView;

    public OperationControlleur(Gamme gamme, ListView<Operation> opListView) {
        this.gamme = gamme;
        this.opListView = opListView;
    }

    public void handleAjoutOperation(Operation addOperationPlaceholder) {
        opListView.setOnMouseClicked(event -> {
            Operation selected = opListView.getSelectionModel().getSelectedItem();
            if (selected == addOperationPlaceholder) {
                CreerOperationView creerView = new CreerOperationView(gamme);
                creerView.getValiderBtn().setOnAction(e -> {
                    Operation op = new Operation(
                        creerView.getRefOperation(),
                        creerView.getDOperation(),
                        creerView.getRefEquipement(),
                        creerView.getDureeOperation()
                    );
                    gamme.getListeOperations().add(op);
                    opListView.getItems().add(opListView.getItems().size() - 1, op);
                    creerView.close();
                });
                creerView.show();
            }
        });
    }

    public void handleSuppressionDepuisBouton(Button deleteOpBtn, Operation addOperationPlaceholder) {
        deleteOpBtn.setOnAction(e -> {
            Operation selected = opListView.getSelectionModel().getSelectedItem();
            if (selected != null && !"+ Ajouter une opération".equals(selected.getRefOperation())) {
                opListView.getItems().remove(selected);
                gamme.getListeOperations().remove(selected);
            }
        });
    }

    public void handleListViewActions(Operation addOperationPlaceholder) {
        opListView.setOnMouseClicked(event -> {
            Operation selected = opListView.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1) {
                if (selected == addOperationPlaceholder) {
                    CreerOperationView creerView = new CreerOperationView(gamme);
                    creerView.getValiderBtn().setOnAction(e -> {
                        Operation op = new Operation(
                            creerView.getRefOperation(),
                            creerView.getDOperation(),
                            creerView.getRefEquipement(),
                            creerView.getDureeOperation()
                        );
                        gamme.getListeOperations().add(op);
                        opListView.getItems().add(opListView.getItems().size() - 1, op);
                        creerView.close();
                    });
                    creerView.show();
                }
            } else if (event.getClickCount() == 2) {
                if (selected != null && selected != addOperationPlaceholder) {
                    view.ModifierOperationView modifView = new view.ModifierOperationView(selected);
                    modifView.getValiderBtn().setOnAction(e -> {
                        selected.setRefOperation(modifView.getRefOperation());
                        selected.setDOperation(modifView.getDOperation());
                        selected.setRefEquipement(modifView.getRefEquipement());
                        selected.setDureeOperation(modifView.getDureeOperation());
                        opListView.refresh();
                        modifView.close();
                    });
                    modifView.show();
                }
            }
        });
    }
}
