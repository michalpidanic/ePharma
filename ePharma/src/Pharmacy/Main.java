package Pharmacy;

import Users.HeadPharmacist;
import Users.LoginService;
import Users.Pharmacist;

public class Main {
    public static void main(String[] args) {
        int id = 0;
        String username = "admin1";
        String password = "admin1";

        //initialization
        Pharmacy pharmacy = Pharmacy.getInstance();
        HeadPharmacist boss = new HeadPharmacist("admin", "admin", String.valueOf(++id));
        pharmacy.getEmployees().add(boss);
        pharmacy.getEmployeesLogin().put(boss.getUsername(), boss.getPassword());

        //new employee registration
        boss.registerUser("admin1", "admin1", String.valueOf(++id), pharmacy);

        //creating medicine objects
        Medicine paralen = new Medicine("Paralen", 1.99, false);
        Medicine muconasal = new Medicine("Muconasal", 4.49, false);
        Medicine ibalgin = new Medicine("Ibalgin", 4.49, false);
        Medicine acylpyrin = new Medicine("Acylpyrin", 2.29, false);
        Medicine ascorutin = new Medicine("Ascorutin", 5.99, false);
        Medicine novalgin = new Medicine("Novalgin", 1.40, true);
        Medicine agen = new Medicine("Agen", 0.42, true);
        Medicine concor = new Medicine("Concor", 2.78, true);
        Medicine nebilet = new Medicine("Nebilet", 1.17, true);
        Medicine stilnox = new Medicine("Stilnox", 1.06, true);

        //adding and removing medicine from storage
        pharmacy.getStorage().addToStorage(paralen, 10);
        pharmacy.getStorage().addToStorage(muconasal, 10);
        pharmacy.getStorage().addToStorage(ibalgin, 10);
        pharmacy.getStorage().addToStorage(acylpyrin, 10);
        pharmacy.getStorage().addToStorage(ascorutin, 10);
        pharmacy.getStorage().addToStorage(novalgin, 10);
        pharmacy.getStorage().addToStorage(agen, 10);
        pharmacy.getStorage().addToStorage(concor, 10);
        pharmacy.getStorage().addToStorage(nebilet, 10);
        pharmacy.getStorage().addToStorage(stilnox, 10);

        //adding and removing medicine from order
        Order order = new Order(String.valueOf(id));
        order.addToOrder(ibalgin, 5, pharmacy.getStorage());
        order.addToOrder(agen, 2, pharmacy.getStorage());
        order.addToOrder(paralen, 10, pharmacy.getStorage());
        System.out.println("pocet paralenov v sklade " + pharmacy.getStorage().getQuantity().get(pharmacy.getStorage().getItems().indexOf(paralen)));
        order.takeFromOrder(paralen, pharmacy.getStorage());
        System.out.println("pocet paralenov v sklade " + pharmacy.getStorage().getQuantity().get(pharmacy.getStorage().getItems().indexOf(paralen)));
        for(int i = 0; i < 9; i++) {
            order.takeFromOrder(paralen, pharmacy.getStorage());
        }
        System.out.println("pocet paralenov v sklade " + pharmacy.getStorage().getQuantity().get(pharmacy.getStorage().getItems().indexOf(paralen)));

        //login as Customer
        String insuranceNumber = "0000000010";
        LoginService.verifyLogin(insuranceNumber, pharmacy);
        pharmacy.logout(pharmacy.getLoggedInUser());

        //login as Pharmacist
        LoginService.verifyLogin(username, password, pharmacy);
        pharmacy.logout(pharmacy.getLoggedInUser());
    }
}
