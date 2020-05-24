package model.pharmacy;

import java.io.Serializable;

public class Medicine implements Serializable {
    private String name;
    private double price;
    private boolean prescription;

    public Medicine(String name, double price, boolean prescription) {
        this.name = name;
        this.price= price;
        this.prescription = prescription;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPrescription() {
        return prescription;
    }
}
