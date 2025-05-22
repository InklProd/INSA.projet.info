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
        this.listView = listView;
        this.listView.setPrefHeight(150);
        this.listView.setCellFactory(list -> new CheckBoxControlleur());

        // Crée le conteneur qui va contenir la liste des postes et la liste des machines
        container = new HBox(10, listView);
        container.setAlignment(Pos.CENTER);

        this.listView.setOnMouseClicked(event -> {
            Object selected = getSelectedItem();

            if (event.getClickCount() == 1) {
                if (machineListView != null) {
                    if (selected instanceof Poste) {
                        Poste poste = (Poste) selected;
                        machineListView.getItems().setAll(
                            poste.getListeMachines().stream().map(Object::toString).collect(Collectors.toList())
                        );
                        if (!container.getChildren().contains(machineListView)) {
                            container.getChildren().add(machineListView);
                        }
                        machineListView.setVisible(true);
                    } else {
                        machineListView.getItems().clear();
                        machineListView.setVisible(false);
                        container.getChildren().remove(machineListView);
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

    // Retourne le conteneur centré
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
        this.machineListView.setVisible(false); // Masquer par défaut
        // S'assurer qu'elle n'est pas dans le container au début
        if (container.getChildren().contains(machineListView)) {
            container.getChildren().remove(machineListView);
        }
    }
}