package model;

import java.time.LocalDateTime;

public class EvenementMaintenance {
    private LocalDateTime dateHeure;
    private Machine refmachine;
    private String typeEvenement; // "A" ou "D"
    private String refoperateur;
    private String cause;

    public EvenementMaintenance(LocalDateTime dateHeure, Machine refmachine, String typeEvenement, String refoperateur, String cause) {
        this.dateHeure = dateHeure;
        this.refmachine = refmachine;
        this.typeEvenement = typeEvenement;
        this.refoperateur = refoperateur;
        this.cause = cause;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public Machine getMachine() {
        return refmachine;
    }

    public String getTypeEvenement() {
        return typeEvenement;
    }

    public String getOperateur() {
        return refoperateur;
    }

    public String getCause() {
        return cause;
    }
}
