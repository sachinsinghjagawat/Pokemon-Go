package com.example.task3.adapterBhaibandhu;

public class TypeItem {

    private String type;
    private String noDamageTo;
    private String halfDamageTo;
    private String doubleDamageTo;
    private String noDamageFrom;
    private String halfDamageFrom;
    private String doubleDamageFrom;
    private String moveDamageClass;
    private boolean expanded;

    public String getType() {
        return type;
    }

    public String getNoDamageTo() {
        return noDamageTo;
    }

    public String getHalfDamageTo() {
        return halfDamageTo;
    }

    public String getDoubleDamageTo() {
        return doubleDamageTo;
    }

    public String getNoDamageFrom() {
        return noDamageFrom;
    }

    public String getHalfDamageFrom() {
        return halfDamageFrom;
    }

    public String getDoubleDamageFrom() {
        return doubleDamageFrom;
    }

    public String getMoveDamageClass() {
        return moveDamageClass;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public TypeItem(String type, String noDamageTo, String halfDamageTo, String doubleDamageTo,
                    String noDamageFrom, String halfDamageFrom, String doubleDamageFrom, String moveDamageClass) {
        this.type = type;
        this.noDamageTo = noDamageTo;
        this.halfDamageTo = halfDamageTo;
        this.doubleDamageTo = doubleDamageTo;
        this.noDamageFrom = noDamageFrom;
        this.halfDamageFrom = halfDamageFrom;
        this.doubleDamageFrom = doubleDamageFrom;
        this.moveDamageClass = moveDamageClass;
        expanded = false;
    }
}
