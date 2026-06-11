package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {
    private Media media;
    private Cart cart;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    public ItemController(Cart cart) {
        this.cart = cart;
    }
    public void setData(Media media) {
        this.media = media;

        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
            btnPlay.setManaged(true);
        } else {
            btnPlay.setVisible(false);
            btnPlay.setManaged(false);
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        try {
            cart.addMedia(media);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Success");
            alert.setContentText(media.getTitle() + " has been added to cart!");
            alert.showAndWait();
        } catch (LimitExceededException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message");
            alert.setHeaderText("Cannot add media to cart");
            alert.setContentText(exception.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("AIMS Player");
                alert.setHeaderText(null);
                alert.setContentText("Playing media: " + media.getTitle());
                alert.showAndWait();
            } catch (PlayerException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("AIMS Player");
                alert.setHeaderText("Cannot play media");
                alert.setContentText(exception.getMessage());
                alert.showAndWait();
            }
        }
    }
}
