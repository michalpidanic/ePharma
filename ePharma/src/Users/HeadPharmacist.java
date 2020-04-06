package Users;

import Pharmacy.Pharmacy;

import java.util.ArrayList;
import java.util.HashMap;

public class HeadPharmacist extends Pharmacist {
    public HeadPharmacist(String name, String password, String id) {
        super(name, password, id);
    }

    public Pharmacist registerUser(String name, String password, String id, Pharmacy pharmacy) {
        Pharmacist pharmacist = new Pharmacist(name, password, id);
        pharmacy.getEmployeesLogin().put(name, password);
        pharmacy.getEmployees().add(pharmacist);
        return pharmacist;
    }
}
