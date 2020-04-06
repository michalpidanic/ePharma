package Pharmacy;

public class Medicine {
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
