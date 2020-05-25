package services;

import model.pharmacy.Pharmacy;
import model.users.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Service for providing login verification for any login data for customer and pharmacist with boolean return value
 */
public class LoginService {
    /**
     * Method for customer login, verifies insurance number, when correct calls login method from pharmacy class
     * @param id Insurance number
     * @param pharmacy Pharmacy object where the user will be logged in
     * @return Boolean value whether verification was successful
     */
    public static boolean verifyLogin(String id, Pharmacy pharmacy) {
        boolean found = false;
        String tempId = "";
        String prescription= "";

        try {
            Scanner scan = new Scanner(new File("resources/patients.txt"));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext() && !found) {
                tempId = scan.next();
                prescription = scan.next();

                if(tempId.equals(id)) {
                    Customer customer = new Customer(id);
                    if(prescription.equals("t")) {
                        customer.setHasPrescription(true);
                    }
                    pharmacy.login(customer);
                    return true;
                }
            }
            scan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Method for employee login, verifies login data, when correct calls login method from pharmacy class
     * @param username Username
     * @param password Password
     * @param pharmacy Pharmacy object where the user will be logged in
     * @return Boolean value whether verification was successful
     */
    public static boolean verifyLogin(String username, String password, Pharmacy pharmacy) {
        if(pharmacy.getEmployeesLogin().containsKey(username)) {
            if(pharmacy.getEmployeesLogin().get(username).equals(password)) {
                pharmacy.login(pharmacy.findUser(username, pharmacy.getEmployees()));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
