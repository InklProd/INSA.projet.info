package model;

public class Machine {
    private String refMachine;
    private String dMachine;
    private String type;
    private float cout;
    private float x;
    private float y;
    private float tempsMarche = 0f;
    private float tempsObservation = 0f;

    public Machine(String refMachine, String dMachine, String type, float cout, float x, float y) {
        this.refMachine = refMachine;
        this.dMachine = dMachine;
        this.type = type;
        this.cout = cout;
        this.x = x;
        this.y = y;
    }

    public String getRefMachine() { return refMachine; }
    public String getDMachine() { return dMachine; }
    public String getType() { return type; }
    public float getCout() { return cout; }
    public float getX() { return x; }
    public float getY() { return y; }
    public float getTempsMarche() { return tempsMarche; }
    public float getTempsObservation() { return tempsObservation; }

    public void setRefMachine(String refMachine) { this.refMachine = refMachine; }
    public void setDMachine(String dMachine) { this.dMachine = dMachine; }
    public void setType(String type) { this.type = type; }
    public void setCout(float cout) { this.cout = cout; }
    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
    public void setTempsMarche(float tempsMarche) { this.tempsMarche = tempsMarche; }
    public void setTempsObservation(float tempsObservation) { this.tempsObservation = tempsObservation; }

    public void afficheMachine() {
        System.out.println("Ref: " + refMachine + ", Désignation: " + dMachine + ", Type: " + type +
                ", Coût: " + cout + ", Position: (" + x + ", " + y + ")");
    }

    public void modifierMachine(String dMachine, String type, float cout, float x, float y) {
        this.dMachine = dMachine;
        this.type = type;
        this.cout = cout;
        this.x = x;
        this.y = y;
    }

    public void supprimerMachine() {
        refMachine = null;
        dMachine = null;
        type = null;
        cout = 0;
        x = 0;
        y = 0;
        tempsMarche = 0;
        tempsObservation = 0;
    }

    public float getFiabilite() {
        if (tempsObservation == 0) return 0;
        return tempsMarche / tempsObservation;
    }

    public String toString() {
        return refMachine + " - " + dMachine;
    }
}

