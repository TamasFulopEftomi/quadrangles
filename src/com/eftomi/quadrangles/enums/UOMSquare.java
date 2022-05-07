package com.eftomi.quadrangles.enums;

public enum UOMSquare {
    MM("m2"), CM("cm2"), DM("dm2"), M("m2"), KM("km2");

    private final String measure;


    private UOMSquare(String measure) {
        this.measure = measure;
    }

    public String getMeasure() {
        return measure;
    }

    @Override
    public String toString() {
        return "UOM{" +
                "measure='" + measure + '\'' +
                '}';
    }

    // számolás azonos mértékegységen történik belül
}
