package services;

import controllers.ItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import model.pharmacy.Medicine;
import model.pharmacy.Storage;

import java.io.IOException;
import java.util.ArrayList;

public class StoreViewService {
    public static void paneInit(Storage storage, VBox pane) {
        ArrayList<Medicine> products = storage.getItems();
        int num = products.size();
        Node[] nodes = new Node[num];
        for (int i = 0; i < nodes.length; i++) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(ProductsViewService.class.getResource("/views/Item.fxml"));
                nodes[i] = loader.load();
                ItemController controller = loader.getController();
                controller.setElements(products.get(i).getName(), products.get(i).getPrice(), products.get(i).isPrescription(), storage.getQuantity().get(i), true);

                pane.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}