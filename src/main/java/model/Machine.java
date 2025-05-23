package model;

public class Machine extends Equipement {
    private String type;
    private float cout;
    private float x;
    private float y;
    private float tempsMarche = 0f;
    private float tempsObservation = 0f;
    private Operation operation;

    public Machine(String refMachine, String dMachine, String type, float cout, float x, float y) {
        super(refMachine, dMachine);
        this.type = type;
        this.cout = cout;
        this.x = x;
        this.y = y;
    }

    public String getRefMachine() { return getRefEquipement(); }
    public String getDMachine() { return getDEquipement(); }
    public String getType() { return type; }
    public float getCout() { return cout; }
    public float getX() { return x; }
    public float getY() { return y; }
    public float getTempsMarche() { return tempsMarche; }
    public float getTempsObservation() { return tempsObservation; }

    public void setRefMachine(String refMachine) { setRefEquipement(refMachine); }
    public void setDMachine(String dMachine) { setDEquipement(dMachine); }
    public void setType(String type) { this.type = type; }
    public void setCout(float cout) { this.cout = cout; }
    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
    public void setTempsMarche(float tempsMarche) { this.tempsMarche = tempsMarche; }
    public void setTempsObservation(float tempsObservation) { this.tempsObservation = tempsObservation; }

    public void afficheMachine() {
        System.out.println("Ref: " + getRefEquipement() + ", Désignation: " + getDEquipement() + ", Type: " + type +
                ", Coût: " + cout + ", Position: (" + x + ", " + y + ")");
    }

    public void modifierMachine(String dMachine, String type, float cout, float x, float y) {
        this.type = type;
        this.cout = cout;
        this.x = x;
        this.y = y;
    }

    public void supprimerMachine() {
        setRefEquipement(null);
        setDEquipement(null);
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
        return getRefEquipement() + " - " + getDEquipement();
    }
}

