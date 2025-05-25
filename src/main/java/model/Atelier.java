package model;

import java.util.ArrayList;
import java.util.List;

public class Atelier {
    private ArrayList<Poste> listePostes;
    private ArrayList<Operateur> listeOperateurs;
    private ArrayList<Gamme> listeGammes;

    public Atelier() {
        listePostes = new ArrayList<>();
        listeOperateurs = new ArrayList<>();
        listeGammes = new ArrayList<>();
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

    public void ajouterGamme(Gamme gamme) {
        listeGammes.add(gamme);
    }

    public void retirerGamme(Gamme gamme) {
        listeGammes.remove(gamme);
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

    public ArrayList<Gamme> getListeGammes() {
        return listeGammes;
    }

    public List<Machine> getAllMachines() {
        List<Machine> allMachines = new ArrayList<>();
        for (Poste poste : listePostes) {
            allMachines.addAll(poste.getListeMachines());
        }
        return allMachines;
    }
}
