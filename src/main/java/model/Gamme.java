package model;

import java.util.ArrayList;

public class Gamme {
    private String refGamme;
    private ArrayList<Operation> listeOperations;
    private ArrayList<Equipement> listeEquipements;
    private ArrayList<Produit> produitsFabriques = new ArrayList<>();

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

    public String getRefGamme() {
        return refGamme;
    }

    public void setRefGamme(String refGamme) {
        this.refGamme = refGamme;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public ArrayList<Equipement> getListeEquipements() {
        return listeEquipements;
    }

    public void ajouterProduit(Produit produit) {
        if (!produitsFabriques.contains(produit)) {
            produitsFabriques.add(produit);
            produit.ajouterGamme(this); // synchronisation bidirectionnelle
        }
    }

    public void retirerProduit(Produit produit) {
        if (produitsFabriques.remove(produit)) {
            produit.retirerGamme(this);
        }
    }

    public ArrayList<Produit> getProduitsFabriques() {
        return produitsFabriques;
    }

    public void afficherProduitsFabriques() {
        System.out.println("Produits fabriqués par la gamme " + refGamme + " :");
        for (Produit p : produitsFabriques) {
            System.out.println("- " + p.getCodeProduit() + " : " + p.getDProduit());
        }
    }
}

