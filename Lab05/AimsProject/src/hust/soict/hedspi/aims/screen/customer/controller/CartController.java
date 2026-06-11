package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class CartController {
    private Cart cart;
    private Store store;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private TableColumn<Media, Integer> colMediaId;

    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label costLabel;

    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    private FilteredList<Media> filteredList;

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        updateTotalCost();

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable,
                                        Media oldValue, Media newValue) {
                        updateButtonBar(newValue);
                    }
                }
        );
        updateTotalCost();
    }

    private void updateTotalCost() {
        costLabel.setText(cart.totalCost() + " $");
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null && media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("AIMS Player");
                alert.setHeaderText(null);
                alert.setContentText("Playing media: " + media.getTitle());
                alert.showAndWait();
            } catch (PlayerException exception) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("AIMS Player");
                alert.setHeaderText("Cannot play media");
                alert.setContentText(exception.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.empty();
        updateTotalCost();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order");
        alert.setHeaderText("Order placed");
        alert.setContentText("An order has been created.");
        alert.showAndWait();
    }

    private void showFilteredMedia(String filterText) {
        filteredList.setPredicate(media -> {
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = filterText.toLowerCase();

            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false;
        });
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {

            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.FXML";

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);

            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
