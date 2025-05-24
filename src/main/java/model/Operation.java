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

    public String getRefOperation() {
        return refOperation;
    }

    public String getDOperation() {
        return dOperation;
    }

    public void setRefOperation(String refOperation) {
        this.refOperation = refOperation;
    }

    public void setDOperation(String dOperation) {
        this.dOperation = dOperation;
    }

    public void setRefEquipement(String refEquipement) {
        this.refEquipement = refEquipement;
    }

    public void setDureeOperation(float dureeOperation) {
        this.dureeOperation = dureeOperation;
    }

    public String toString() {
        return refOperation;
    }
}

