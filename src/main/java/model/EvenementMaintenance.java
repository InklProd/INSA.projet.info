package model;

import java.time.LocalDateTime;

public class EvenementMaintenance {
    private LocalDateTime dateHeure;
    private Machine machine;
    private String typeEvenement; // "A" ou "D"
    private String operateur;
    private String cause;

    public EvenementMaintenance(LocalDateTime dateHeure, Machine machine, String typeEvenement, String operateur, String cause) {
        this.dateHeure = dateHeure;
        this.machine = machine;
        this.typeEvenement = typeEvenement;
        this.operateur = operateur;
        this.cause = cause;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public Machine getMachine() {
        return machine;
    }

    public String getTypeEvenement() {
        return typeEvenement;
    }

    public String getOperateur() {
        return operateur;
    }

    public String getCause() {
        return cause;
    }
}
