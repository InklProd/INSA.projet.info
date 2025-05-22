package controlleur;
import javafx.scene.control.ListView;
import model.Operateur;
import model.Poste;

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
                    System.out.println("Double-clic sur operateur : " + selected);
                }
                if (selected instanceof Poste) {
                    System.out.println("Double-clic sur poste : " + selected);
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