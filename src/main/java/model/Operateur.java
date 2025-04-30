/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author emili
 */
public class Operateur {
    private String code;
    private String nom;
    private String prenom;
    private String[] competences;
    private boolean estOccupe;

    public Operateur(String code, String nom, String prenom, String[] competences) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.competences = competences;
        this.estOccupe = false;
    }

    public void afficherOperateur() {
        System.out.println("Code: " + code + ", Nom: " + nom + " " + prenom);
        System.out.print("Compétences : ");
        for (String c : competences) {
            System.out.print(c + " ");
        }
        System.out.println("\nStatut : " + (estOccupe ? "Occupé" : "Libre"));
    }

    public void changerStatut(boolean occupe) {
        this.estOccupe = occupe;
    }

    public boolean estDisponible() {
        return !estOccupe;
    }

    // Getters & setters possibles
}
