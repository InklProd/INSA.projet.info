package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import model.Atelier;
import model.Poste;

public class BoutonPosteController {
    private final Button bouton;
    private Poste poste;
    boolean actionAjouter=true;
    
    public BoutonPosteController(Atelier atelier, TextArea zoneAffichage/*, Vbox zoneAction*/) {
        bouton = new Button("Afficher les postes");
        bouton.setPrefSize(50,50);
        
        bouton.setOnAction(e -> {
            StringBuilder sb = new StringBuilder("Postes disponibles :\n");
            atelier.getListePostes().forEach(p -> sb.append("- ").append(p).append("\n"));
            zoneAffichage.setText(sb.toString());
            
            /*if (!actionAjouter){
                Button action1 = new Button("creer poste");
                Button action2 = new Button("suprimer poste");

                action1.setOnAction(ev -> atelier.ajouterPoste(poste));
                action2.setOnAction(ev -> atelier.retirerPoste(poste));

                zoneAction.getChildren().addAll(action1, action2);
                
                actionAjouter = true;
            }*/

        });
        /*this.zoneAction = zoneAction;*/
    }

    public Button getButton() {
        return bouton;
    }
}