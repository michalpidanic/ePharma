package Users;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Pharmacist extends User {
    public Pharmacist(String name, String password) throws FileNotFoundException, UnsupportedEncodingException {
        super(name, password);
    }

}
