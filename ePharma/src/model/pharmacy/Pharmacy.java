package model.pharmacy;
import model.users.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Pharmacy implements Serializable {
    private static Pharmacy instance;
    private ArrayList<Pharmacist> employees;
    private HashMap<String, String> employeesLogin;
    private User loggedInUser;
    private Storage storage;
    private Order order;

    private Pharmacy() {
        this.employees= new ArrayList<>();
        this.employeesLogin = new HashMap<>();
        this.loggedInUser = null;
        this.storage = new Storage();
    }

    public static Pharmacy getInstance() {
        if(instance == null) {
            instance = new Pharmacy();
        }
        return instance;
    }

    public void login(User user) {
        this.loggedInUser = user;
        this.order = new Order(user.getUserId());
        user.setLoginStatus(true);
    }

    public void logout(User user) {
        this.loggedInUser = null;
        this.order = null;
        user.setLoginStatus(false);
    }

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

    public void setEmployees(ArrayList<Pharmacist> employees) {
        this.employees = employees;
    }

    public HashMap<String, String> getEmployeesLogin() {
        return employeesLogin;
    }

    public void setEmployeesLogin(HashMap<String, String> employeesLogin) {
        this.employeesLogin = employeesLogin;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
