package controlleur;

import java.util.stream.Collectors;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import model.Operateur;
import model.Poste;
import view.ModifierOperateurView;
import view.ModifierPosteView;

public class PosteOpListeView {
    private ListView<Object> listView;
    private ListView<String> machineListView;
    private HBox container;

    public PosteOpListeView(ListView<Object> listView) {
        int l = 250;
        int L = 300;
        this.listView = listView;
        this.listView.setPrefHeight(l);
        this.listView.setPrefWidth(L*2);
        this.listView.setCellFactory(list -> new CheckBoxControlleur());

        container = new HBox(10, listView);
        container.setAlignment(Pos.CENTER);

        this.listView.setOnMouseClicked(event -> {
            Object selected = getSelectedItem();

            if (event.getClickCount() == 1) {
                if (machineListView != null) {
                    this.machineListView.setPrefHeight(l);
                    this.machineListView.setPrefWidth(L);
                    this.listView.setPrefWidth(L);
                    if (selected instanceof Poste) {
                        Poste poste = (Poste) selected;
                        machineListView.getItems().setAll(
                            poste.getListeMachines().stream().map(Object::toString).collect(Collectors.toList())
                        );
                    } else {
                        machineListView.getItems().clear();
                    }
                }
                listView.refresh();
            }

            if (event.getClickCount() == 2) {
                if (selected instanceof Operateur) {
                    ModifierOperateurView fenetre = new ModifierOperateurView((Operateur) selected);
                    fenetre.setOnHidden(ev -> listView.refresh());
                    fenetre.show();
                }
                if (selected instanceof Poste) {
                    ModifierPosteView fenetre = new ModifierPosteView((Poste) selected);
                    fenetre.setOnHidden(ev -> listView.refresh());
                    fenetre.show();
                }
            }
        });
    }

    public HBox getCenteredView() {
        return container;
    }

    public ListView<Object> getView() {
        return listView;
    }

    public Object getSelectedItem() {
        return listView.getSelectionModel().getSelectedItem();
    }

    public void setMachineListView(ListView<String> machineListView) {
        this.machineListView = machineListView;
    }

    public javafx.scene.control.ListView<String> getMachineListView() {
        return this.machineListView;
    }

    public void hideMachineListView() {
        if (machineListView != null) {
            machineListView.getItems().clear();
            machineListView.setVisible(false);
            machineListView.setManaged(false);
        }
    }
}