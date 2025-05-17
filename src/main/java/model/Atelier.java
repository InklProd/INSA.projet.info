/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Atelier {
    private ArrayList<Poste> listePostes;
    private ArrayList<Operateur> listeOperateurs;

    public Atelier() {
        listePostes = new ArrayList<>();
        listeOperateurs = new ArrayList<>();
    }

    public void ajouterPoste(Poste poste) {
        listePostes.add(poste);
    }

    public void retirerPoste(Poste poste) {
        listePostes.remove(poste);
    }

    public void ajouterOperateur(Operateur op) {
        listeOperateurs.add(op);
    }

    public void retirerOperateur(Operateur op) {
        listeOperateurs.remove(op);
    }

    public void afficherAtelier() {
        System.out.println("Liste des postes de travail :");
        for (Poste p : listePostes) {
            p.affichePoste();
        }

        System.out.println("\nListe des opérateurs :");
        for (Operateur o : listeOperateurs) {
            o.afficherOperateur();
        }
    }

    public ArrayList<Poste> getListePostes() {
        return listePostes;
    }

    public ArrayList<Operateur> getListeOperateurs() {
        return listeOperateurs;
    }
}
