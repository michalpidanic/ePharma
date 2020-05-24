package services;

import controllers.ProductController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import model.pharmacy.Medicine;
import model.pharmacy.Storage;

import java.io.IOException;
import java.util.ArrayList;

public class ProductsViewService {
    public static void paneInit(Storage storage, VBox pane) {
        ArrayList<Medicine> products = storage.getItems();
        int num = products.size();
        Node[] nodes = new Node[num];
        for (int i = 0; i < nodes.length; i++) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(ProductsViewService.class.getResource("/views/Product.fxml"));
                nodes[i] = loader.load();
                ProductController controller = loader.getController();
                controller.setElements(products.get(i).getName(), products.get(i).getPrice(), products.get(i).isPrescription());

                pane.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
