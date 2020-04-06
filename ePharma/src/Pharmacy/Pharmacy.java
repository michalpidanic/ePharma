package Pharmacy;
import Users.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Pharmacy {
    private static Pharmacy instance;
    ArrayList<Pharmacist> employees;
    HashMap<String, String> employeesLogin;
    User loggedInUser;
    Storage storage;
    Order order;

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
}
