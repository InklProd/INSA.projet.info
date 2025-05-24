package model;

import java.util.ArrayList;

public class Produit {
    private String codeProduit;
    private String dProduit;
    private ArrayList<Gamme> gammes = new ArrayList<>();

    public Produit(String codeProduit, String dProduit) {
        this.codeProduit = codeProduit;
        this.dProduit = dProduit;
        model.ProduitRepository.addProduit(this);
    }

    public void afficheProduit() {
        System.out.println("Code: " + codeProduit + ", Désignation: " + dProduit);
    }

    public void modifierProduit(String code, String designation) {
        this.codeProduit = code;
        this.dProduit = designation;
    }

    public void supprimerProduit() {
        this.codeProduit = null;
        this.dProduit = null;
    }

    public void ajouterGamme(Gamme gamme) {
        if (!gammes.contains(gamme)) {
            gammes.add(gamme);
            gamme.ajouterProduit(this); // synchronisation bidirectionnelle
        }
    }

    public void retirerGamme(Gamme gamme) {
        gammes.remove(gamme);
    }

    public ArrayList<Gamme> getGammes() {
        return gammes;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public String getDProduit() {
        return dProduit;
    }
}
