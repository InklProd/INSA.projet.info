package controlleur;
import javafx.scene.control.ListView;
import model.Operateur;
import model.Poste;
import view.ModifierOperateurView;
import view.ModifierPosteView;

public class ModifierControlleur {
    private ListView<Object> listView;

    public ModifierControlleur(ListView<Object> listView) {
        this.listView = listView;
        this.listView.setPrefHeight(150);
        this.listView.setCellFactory(list -> new CheckBoxControlleur());
        this.listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Object selected = getSelectedItem();
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

    public ListView<Object> getView() {
        return listView;
    }

    public Object getSelectedItem() {
        return listView.getSelectionModel().getSelectedItem();
    }
}