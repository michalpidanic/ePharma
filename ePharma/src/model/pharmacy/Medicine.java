package model.pharmacy;

import java.io.Serializable;

/**
 * Class medicine creates instances of medicine with name, price and information about if presription is needed
 */
public class Medicine implements Serializable {
    private String name;
    private double price;
    private boolean prescription;

    /**
     * Constructor
     * @param name Name of medicine
     * @param price Price of medicine
     * @param prescription Prescription boolean info
     */
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
