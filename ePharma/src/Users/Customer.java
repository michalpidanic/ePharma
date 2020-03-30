package Users;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Customer extends User {
    protected String address;
    protected String insuranceNumber;
    protected double budget;
    protected boolean hasPrescription;

    public Customer(String name, String password, String address, String insurance, double budget, boolean prescription) throws FileNotFoundException, UnsupportedEncodingException {
        super(name, password);
        this.address = address;
        this.insuranceNumber = insurance;
        this.budget = budget;
        this.hasPrescription = prescription;
    }

    public void buyFreeMedicine () {

    }

    public void pay () {

    }
}
