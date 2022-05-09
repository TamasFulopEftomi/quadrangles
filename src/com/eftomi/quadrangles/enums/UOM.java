package com.eftomi.quadrangles.enums;

public enum UOM {
    MM ("m"), CM("cm"), DM("dm"), M("m"), KM("km");

    private final String measure;


    private UOM(String measure) {
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

}

