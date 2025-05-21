package controlleur;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import model.Operateur;
import model.Poste;

public class CheckBoxControlleur extends ListCell<Object> {

    @Override
    protected void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else if (item instanceof Operateur) {
            Operateur op = (Operateur) item;
            setText(op.toString());
            CheckBox checkBox = new CheckBox();
            checkBox.setSelected(!op.estDisponible());
            checkBox.setOnAction(e -> op.changerStatut(checkBox.isSelected()));
            setGraphic(checkBox);
        } else if (item instanceof Poste) {
            Poste poste = (Poste) item;
            setText(poste.toString());
            setGraphic(null);
        } else {
            setText(item.toString());
            setGraphic(null);
        }
    }
}
