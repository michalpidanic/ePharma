package model.users;

import model.pharmacy.Pharmacy;

/**
 * Class for boss of pharmacy
 */
public class HeadPharmacist extends Pharmacist {
    /**
     * Constructor
     * @param name Username
     * @param password Password
     * @param id Id
     */
    public HeadPharmacist(String name, String password, String id) {
        super(name, password, id);
    }

    /**
     * Method for registration of new employee
     * @param name New username
     * @param password New password
     * @param id New id
     * @param pharmacy Pharmacy instance
     */
    public void registerUser(String name, String password, String id, Pharmacy pharmacy) {
        pharmacy.getEmployeesLogin().put(name, password);
        pharmacy.getEmployees().add(new Pharmacist(name, password, id));
    }
}
