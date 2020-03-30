package Pharmacy;

public class Medicine {
    private String name;
    private String application;
    private double price;
    private boolean prescription;

    public Medicine(String name, String application, double price, boolean prescription) {
        this.name = name;
        this.application = application;
        this.price= price;
        this.prescription = prescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }
}
