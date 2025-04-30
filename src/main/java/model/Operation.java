/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author emili
 */
public class Operation {
    private String refOperation;
    private String dOperation;
    private String refEquipement;
    private float dureeOperation;

    public Operation(String refOperation, String dOperation, String refEquipement, float dureeOperation) {
        this.refOperation = refOperation;
        this.dOperation = dOperation;
        this.refEquipement = refEquipement;
        this.dureeOperation = dureeOperation;
    }

    public float getDureeOperation() {
        return dureeOperation;
    }

    public String getRefEquipement() {
        return refEquipement;
    }
}

