package Services;

import Pharmacy.Pharmacy;
import Users.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginService {
    public static void verifyLogin(String id, Pharmacy pharmacy) {
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
                    return;
                }
            }
            scan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Wrong insurance number, please try again.");
    }

    public static void verifyLogin(String username, String password, Pharmacy pharmacy) {
        if(pharmacy.getEmployeesLogin().containsKey(username)) {
            if(pharmacy.getEmployeesLogin().get(username).equals(password)) {
                pharmacy.login(pharmacy.findUser(username, pharmacy.getEmployees()));
            } else {
                System.out.println("Incorrect password, please try again.");
            }
        } else {
            System.out.println("Incorrect username, please try again.");
        }
    }
}
