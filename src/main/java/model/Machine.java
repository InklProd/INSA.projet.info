/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author emili
 */
public class Machine {
    private String refMachine;
    private String dMachine;
    private String type;
    private float cout;
    private float x;
    private float y;

    public Machine(String refMachine, String dMachine, String type, float cout, float x, float y) {
        this.refMachine = refMachine;
        this.dMachine = dMachine;
        this.type = type;
        this.cout = cout;
        this.x = x;
        this.y = y;
    }

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
    }

    public float getCout() {
        return cout;
    }

    private float tempsMarche = 0f;
    private float tempsObservation = 0f;

    public void setTempsFonctionnement(float marche, float observation) {
        this.tempsMarche = marche;
        this.tempsObservation = observation;
    }

    public float getFiabilite() {
        if (tempsObservation == 0) return 0;
        return tempsMarche / tempsObservation;
    }
}

