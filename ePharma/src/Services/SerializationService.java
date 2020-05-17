package Services;

import java.io.*;

public class SerializationService {
    public static void serialize(Object object) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("resources/serialization.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(object);
        out.close();
        fileOut.close();
    }

    public static Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("resources/serialization.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object object = in.readObject();
        in.close();
        fileIn.close();
        return object;
    }
}
