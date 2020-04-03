package Pharmacy;

import Users.Customer;
import Users.HeadPharmacist;
import Users.Pharmacist;

public class Main {
    public static void main(String[] args) {
        int id = 0;
        String username = "admin2";
        String password = "admin1";

        Pharmacy pharmacy = new Pharmacy();

        HeadPharmacist boss = new HeadPharmacist("admin", "admin", "1");

        pharmacy.employees.add(boss);
        pharmacy.employeesLogin.put(boss.getUsername(), boss.getPassword());

        Pharmacist user1 = boss.registerUser("admin1", "admin1", "2", pharmacy.employeesLogin, pharmacy.employees);

        //System.out.println(pharmacy.findUser(username, pharmacy.users).verifyLogin(username, password, pharmacy.employees));

        System.out.println(Pharmacist.verifyLogin(username, password, pharmacy.employeesLogin));
        System.out.println(pharmacy.employees);
        System.out.println(pharmacy.employeesLogin);
        System.out.println(Customer.verifyLogin("0000000003"));
    }

}
