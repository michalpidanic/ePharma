package Pharmacy;
import Users.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Pharmacy {
    ArrayList<Pharmacist> employees;
    HashMap<String, String> employeesLogin;

    public Pharmacy() {
        this.employees= new ArrayList<>();
        this.employeesLogin = new HashMap<>();
    }

    //TODO UserNotFoundException
    public Pharmacist findUser(String name, ArrayList<Pharmacist> users) {
        for (Pharmacist user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }
}
