package Users;

import Pharmacy.Pharmacy;

import java.util.ArrayList;
import java.util.HashMap;

public class HeadPharmacist extends Pharmacist {
    public HeadPharmacist(String name, String password, String id) {
        super(name, password, id);
    }

    public void registerUser(String name, String password, String id, Pharmacy pharmacy) { 
        pharmacy.getEmployeesLogin().put(name, password);
        pharmacy.getEmployees().add(new Pharmacist(name, password, id));
    }
}
