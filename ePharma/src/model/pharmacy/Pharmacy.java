package model.pharmacy;
import model.users.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Singleton class which contains every information about Pharmacy
 */
public class Pharmacy implements Serializable {
    private static Pharmacy instance;
    private ArrayList<Pharmacist> employees;
    private HashMap<String, String> employeesLogin;
    private User loggedInUser;
    private Storage storage;
    private Order order;

    /**
     * Private constructor of class, called by getInstance method
     */
    private Pharmacy() {
        this.employees= new ArrayList<>();
        this.employeesLogin = new HashMap<>();
        this.loggedInUser = null;
        this.storage = new Storage();
    }

    /**
     * This method is essential for creating only one instance of Pharmacy
     * @return Pharmacy instance
     */
    public static Pharmacy getInstance() {
        if(instance == null) {
            instance = new Pharmacy();
        }
        return instance;
    }

    /**
     * Method login is called via LoginService after verification of login data, logs user in and creates Order for him
     * @param user User we want to set as logged in
     */
    public void login(User user) {
        this.loggedInUser = user;
        this.order = new Order(user.getUserId());
        user.setLoginStatus(true);
    }

    /**
     * Method for logout logged in user  and deleting users oder
     * @param user Currently logged in user
     */
    public void logout(User user) {
        this.loggedInUser = null;
        this.order = null;
        user.setLoginStatus(false);
    }

    /**
     * Finds user by his name
     * @param name Name of user we want to get
     * @param users ArrayList of all users
     * @return When user exists, then user, else null
     */
    public Pharmacist findUser(String name, ArrayList<Pharmacist> users) {
        for (Pharmacist user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<Pharmacist> getEmployees() {
        return employees;
    }

    public HashMap<String, String> getEmployeesLogin() {
        return employeesLogin;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public Storage getStorage() {
        return storage;
    }

    public Order getOrder() {
        return order;
    }
}
