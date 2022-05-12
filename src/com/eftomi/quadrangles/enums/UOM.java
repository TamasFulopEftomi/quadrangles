package com.eftomi.quadrangles.enums;

public enum UOM {
    MM ("mm", 1), CM("cm", 10), DM("dm", 100),
    M("m", 1_000), KM("km", 1_000_000);

    private final String measure;
    private final int multiplierToMm;


    private UOM(String measure, int multiplierToMm) {
        this.measure = measure;
        this.multiplierToMm = multiplierToMm;
    }

    public String getMeasure() {
        return measure;
    }

    public int getMultiplierToMm() {
        return multiplierToMm;
    }

}

