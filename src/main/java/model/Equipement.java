package model;

public class Equipement {
    private String refEquipement;
    private String dEquipement;

    public Equipement(String refEquipement, String dEquipement) {
        this.refEquipement = refEquipement;
        this.dEquipement = dEquipement;
    }

    public String getRefEquipement() {
        return refEquipement;
    }

    public String getDEquipement() {
        return dEquipement;
    }

    public void setRefEquipement(String refEquipement) {
        this.refEquipement = refEquipement;
    }

    public void setDEquipement(String dEquipement) {
        this.dEquipement = dEquipement;
    }
}

