/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author emili
 */
public class Produit {
    private String codeProduit;
    private String dProduit;

    public Produit(String codeProduit, String dProduit) {
        this.codeProduit = codeProduit;
        this.dProduit = dProduit;
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

    
}
