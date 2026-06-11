package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {
    @FXML
    private GridPane gridPane;

    private Store store;
    private Cart cart;

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.FXML";

        int column = 0;
        int row = 0;

        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));

                ItemController itemController = new ItemController(this.cart);
                fxmlLoader.setController(itemController);

                AnchorPane anchorPane = fxmlLoader.load();
                anchorPane.setMaxWidth(Double.MAX_VALUE);

                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setHgrow(anchorPane, Priority.ALWAYS);
                GridPane.setMargin(anchorPane, new Insets(0, 0, 0, 0));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.FXML";

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));

            CartController cartController = new CartController(store, this.cart);
            fxmlLoader.setController(cartController);

            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
