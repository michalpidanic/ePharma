package services;

import java.io.*;

/**
 * Service for serialization and deserialization
 */
public class SerializationService {
    /**
     * Method serializes object to file serialization.txt
     * @param object Object we want to serialize
     * @throws IOException Exception when .txt file not found
     */
    public static void serialize(Object object) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("resources/serialization.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(object);
        out.close();
        fileOut.close();
    }

    /**
     * Method for object deserialization
     * @return Object type
     * @throws IOException Exception when .txt file not found
     * @throws ClassNotFoundException Exception when class not found
     */
    public static Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("resources/serialization.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object object = in.readObject();
        in.close();
        fileIn.close();
        return object;
    }
}
