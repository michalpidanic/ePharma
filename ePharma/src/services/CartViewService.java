package services;

import controllers.ItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import model.pharmacy.Medicine;
import model.pharmacy.Order;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Service for loading dynamic scrollable view of products in shopping cart
 */
public class CartViewService {
    /**
     * Method for init
     * @param order Order instance which will be visualised
     * @param pane Pane where it will be visualised
     */
    public static void paneInit(Order order, VBox pane) {
        ArrayList<Medicine> products = order.getItems();
        int num = products.size();
        Node[] nodes = new Node[num];
        for (int i = 0; i < nodes.length; i++) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(CartViewService.class.getResource("/views/Item.fxml"));
                nodes[i] = loader.load();

                ItemController controller = loader.getController();
                controller.setElements(products.get(i).getName(), products.get(i).getPrice(), products.get(i).isPrescription(), order.getQuantity().get(i), false);

                pane.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
