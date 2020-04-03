package Pharmacy;
import Users.Customer;
import Users.HeadPharmacist;
import Users.Pharmacist;

public class Main {
    public static void main(String[] args) {
        int id = 0;
        String username = "admin2";
        String password = "admin1";

        //initialization
        Pharmacy pharmacy = new Pharmacy();
        HeadPharmacist boss = new HeadPharmacist("admin", "admin", String.valueOf(++id));
        pharmacy.employees.add(boss);
        pharmacy.employeesLogin.put(boss.getUsername(), boss.getPassword());

        //new employee registration
        Pharmacist user1 = boss.registerUser("admin1", "admin1", String.valueOf(++id), pharmacy.employeesLogin, pharmacy.employees);

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
        pharmacy.storage.addToStorage(paralen, 10);
        pharmacy.storage.addToStorage(muconasal, 10);
        pharmacy.storage.addToStorage(ibalgin, 10);
        pharmacy.storage.addToStorage(acylpyrin, 10);
        pharmacy.storage.addToStorage(ascorutin, 10);
        pharmacy.storage.addToStorage(novalgin, 10);
        pharmacy.storage.addToStorage(agen, 10);
        pharmacy.storage.addToStorage(concor, 10);
        pharmacy.storage.addToStorage(nebilet, 10);
        pharmacy.storage.addToStorage(stilnox, 10);

        //adding and removing medicine from order
        Order order = new Order(String.valueOf(id));
        order.addToOrder(ibalgin, 5, pharmacy.storage);
        order.addToOrder(agen, 2, pharmacy.storage);
        order.addToOrder(paralen, 10, pharmacy.storage);
        System.out.println("pocet paralenov v sklade " + pharmacy.storage.getQuantity().get(pharmacy.storage.getItems().indexOf(paralen)));
        order.takeFromOrder(paralen, pharmacy.storage);
        System.out.println("pocet paralenov v sklade " + pharmacy.storage.getQuantity().get(pharmacy.storage.getItems().indexOf(paralen)));
        for(int i = 0; i < 9; i++) {
            order.takeFromOrder(paralen, pharmacy.storage);
        }
        System.out.println("pocet paralenov v sklade " + pharmacy.storage.getQuantity().get(pharmacy.storage.getItems().indexOf(paralen)));



//        //System.out.println(pharmacy.findUser(username, pharmacy.users).verifyLogin(username, password, pharmacy.employees));
//
//        System.out.println(Pharmacist.verifyLogin(username, password, pharmacy.employeesLogin));
//        System.out.println(pharmacy.employees);
//        System.out.println(pharmacy.employeesLogin);
//        System.out.println(Customer.verifyLogin("0000000003"));
    }
}
