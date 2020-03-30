package Users;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class HeadPharmacist extends Pharmacist {
    public HeadPharmacist(String name, String password) throws FileNotFoundException, UnsupportedEncodingException {
        super(name, password);
    }

    public void addToStorage () {

    }
}
