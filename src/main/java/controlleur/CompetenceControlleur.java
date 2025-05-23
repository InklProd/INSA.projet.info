package controlleur;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import model.Operateur;
import view.CreerCompetenceView;

public class CompetenceControlleur {
    private final ListView<String> competenceListView;
    private final Button creerBtn;
    private final Button supprimerBtn;
    private VBox vbox;
    private Operateur operateurSelectionne;

    public CompetenceControlleur() {
        competenceListView = new ListView<>();
        competenceListView.setPrefWidth(200);
        creerBtn = new Button("Créer compétence");
        supprimerBtn = new Button("Supprimer compétence");
        creerBtn.setOnAction(e -> ouvrirCreerCompetence());
        supprimerBtn.setOnAction(e -> supprimerCompetenceSelectionnee());
        HBox boutons = new HBox(10, creerBtn, supprimerBtn);
        boutons.setStyle("-fx-alignment: center;");
        vbox = new VBox(10, competenceListView, boutons);
        vbox.setStyle("-fx-alignment: center;");
        vbox.setVisible(false);
        vbox.setManaged(false);
    }

    public VBox getView() { return vbox; }
    public void setOperateur(Operateur op) {
        this.operateurSelectionne = op;
        if (op != null) {
            competenceListView.getItems().setAll(op.getCompetences());
            vbox.setVisible(true);
            vbox.setManaged(true);
        } else {
            competenceListView.getItems().clear();
            vbox.setVisible(false);
            vbox.setManaged(false);
        }
    }
    private void ouvrirCreerCompetence() {
        if (operateurSelectionne == null) return;
        CreerCompetenceView fenetre = new CreerCompetenceView(competence -> {
            operateurSelectionne.ajouterCompetence(competence);
            competenceListView.getItems().setAll(operateurSelectionne.getCompetences());
        });
        fenetre.show();
    }
    private void supprimerCompetenceSelectionnee() {
        if (operateurSelectionne == null) return;
        String selected = competenceListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            operateurSelectionne.supprimerCompetence(selected);
            competenceListView.getItems().setAll(operateurSelectionne.getCompetences());
        }
    }
}
