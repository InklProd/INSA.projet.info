/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author emili
 */
import java.time.LocalDateTime;

public class EvenementMaintenance {
    private LocalDateTime dateHeure;
    private String machine;
    private String typeEvenement; // "A" ou "D"
    private String operateur;
    private String cause;

    public EvenementMaintenance(LocalDateTime dateHeure, String machine, String typeEvenement, String operateur, String cause) {
        this.dateHeure = dateHeure;
        this.machine = machine;
        this.typeEvenement = typeEvenement;
        this.operateur = operateur;
        this.cause = cause;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public String getMachine() {
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
