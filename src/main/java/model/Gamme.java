/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bparizot01
 */
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
            // Coût fictif: tu pourrais ajouter une map refEquipement → Machine pour récupérer le coût
            total += op.getDureeOperation() * 50; // À remplacer par un vrai lien vers Machine
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

