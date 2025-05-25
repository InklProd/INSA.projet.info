package model;

import java.util.ArrayList;

public class Poste extends Equipement {
    private ArrayList<Machine> listeMachines;

    public Poste(String refPoste, String dPoste) {
        super(refPoste, dPoste);
        this.listeMachines = new ArrayList<>();
    }

    public void ajouteMachine(Machine m) {
        listeMachines.add(m);
    }

    public void retireMachine(Machine m) {
        listeMachines.remove(m);
    }

    public void affichePoste() {
        System.out.println("Poste: " + getRefEquipement() + ", " + getDEquipement());
        for (Machine m : listeMachines) {
            m.afficheMachine();
        }
    }

    public void supprimerPoste() {
        listeMachines.clear();
        setRefEquipement(null);
        setDEquipement(null);
    }

    public ArrayList<Machine> getListeMachines() {
        return listeMachines;
    }

    public String getRefPoste() {
        return getRefEquipement();
    }

    public String getDPoste() {
        return getDEquipement();
    }

    @Override
    public String toString() {
        return "Réf: " + getRefEquipement() + ", Description: " + getDEquipement();
    }
}

