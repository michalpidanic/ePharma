package model.pharmacy;

import model.users.HeadPharmacist;
import services.SerializationService;

import java.io.IOException;

/**
 * Class that works like factory reset, if something goes wrong, we can create and serialize instance of pharmacy with users, head pharmacist, storage and medicine in it
 */
public class Reset {
    public static void main(String[] args) throws IOException {
        //initialization
        Pharmacy pharmacy = Pharmacy.getInstance();
        HeadPharmacist boss = new HeadPharmacist("admin", "admin", "0");
        pharmacy.getEmployees().add(boss);
        pharmacy.getEmployeesLogin().put(boss.getUsername(), boss.getPassword());

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

        SerializationService.serialize(pharmacy);
    }
}
