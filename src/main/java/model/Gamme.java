package model;

import java.util.ArrayList;

public class Gamme {
    private String refGamme;
    private ArrayList<Operation> listeOperations;
    private ArrayList<Equipement> listeEquipements;

    public Gamme(String refGamme) {
        this.refGamme = refGamme;
        this.listeOperations = new ArrayList<>();
        this.listeEquipements = new ArrayList<>();
    }

    public void creerGamme(Operation op, Equipement eq) {
        listeOperations.add(op);
        listeEquipements.add(eq);
    }

    public void modifierGamme(Operation ancienneOp, Operation nouvelleOp) {
        int index = listeOperations.indexOf(ancienneOp);
        if (index != -1) {
            listeOperations.set(index, nouvelleOp);
        }
    }

    public void supprimerGamme() {
        listeOperations.clear();
        listeEquipements.clear();
    }

    public void afficheGamme() {
        System.out.println("Gamme: " + refGamme);
        for (Equipement e : listeEquipements) {
            System.out.println("Equipement: " + e.getRefEquipement() + " - " + e.getDEquipement());
        }
    }

    public float coutGamme() {
        float total = 0;
        for (Operation op : listeOperations) {
           
            total += op.getDureeOperation() * 50; 
        }
        return total;
    }

    public float dureeGamme() {
        float duree = 0;
        for (Operation op : listeOperations) {
            duree += op.getDureeOperation();
        }
        return duree;
    }
}

