package model;

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

    public String toString() {
        return code + " - " + nom + " " + prenom;
    }

    public void setCode(String code) { this.code = code; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String[] getCompetences() { return competences; }
    public void setCompetences(String[] competences) { this.competences = competences; }
    public String getCode() { return code; }
    
    public void ajouterCompetence(String competence) {
        if (competence == null || competence.isEmpty()) return;
        java.util.List<String> list = new java.util.ArrayList<>(java.util.Arrays.asList(competences));
        list.add(competence);
        competences = list.toArray(new String[0]);
    }
    public void supprimerCompetence(String competence) {
        java.util.List<String> list = new java.util.ArrayList<>(java.util.Arrays.asList(competences));
        list.remove(competence);
        competences = list.toArray(new String[0]);
    }
}
