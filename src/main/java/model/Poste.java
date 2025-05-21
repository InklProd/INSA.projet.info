/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author emili
 */
import java.util.ArrayList;

public class Poste {
    private String refPoste;
    private String dPoste;
    private ArrayList<Machine> listeMachines;

    public Poste(String refPoste, String dPoste) {
        this.refPoste = refPoste;
        this.dPoste = dPoste;
        this.listeMachines = new ArrayList<>();
    }

    public void ajouteMachine(Machine m) {
        listeMachines.add(m);
    }

    public void retireMachine(Machine m) {
        listeMachines.remove(m);
    }

    public void affichePoste() {
        System.out.println("Poste: " + refPoste + ", " + dPoste);
        for (Machine m : listeMachines) {
            m.afficheMachine();
        }
    }

    public void supprimerPoste() {
        listeMachines.clear();
        refPoste = null;
        dPoste = null;
    }

    // Getters
    public ArrayList<Machine> getListeMachines() {
        return listeMachines;
    }

    @Override
    public String toString() {
        return "Réf: " + refPoste + ", Description: " + dPoste;
    }
}

