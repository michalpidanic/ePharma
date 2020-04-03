package Users;

import java.util.ArrayList;
import java.util.HashMap;

public class HeadPharmacist extends Pharmacist {
    public HeadPharmacist(String name, String password, String id) {
        super(name, password, id);
    }

    public Pharmacist registerUser(String name, String password, String id, HashMap<String, String> employeesLogin, ArrayList<Pharmacist> employees) {
        Pharmacist pharmacist = new Pharmacist(name, password, id);
        employeesLogin.put(name, password);
        employees.add(pharmacist);
        return pharmacist;
    }
}
