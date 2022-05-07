package com.eftomi.quadrangles.enums;

public enum UOMCubic {
    MM ("m3"), CM("cm3"), DM("dm3"), M("m3"), KM("km3");

    private final String measure;


    private UOMCubic(String measure) {
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
