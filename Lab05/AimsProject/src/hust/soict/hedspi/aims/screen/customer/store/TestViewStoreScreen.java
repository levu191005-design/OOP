package hust.soict.hedspi.aims.screen.customer.store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.FXML";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        DigitalVideoDisc interstellar = new DigitalVideoDisc(
                "Interstellar", "Movie", "Christopher Nolan", 169, 6.8f);
        DigitalVideoDisc spiderVerse = new DigitalVideoDisc(
                "Spider-Man: Into the Spider-Verse", "Animation", "Bob Persichetti", 117, 5.9f);
        DigitalVideoDisc invalidDvd = new DigitalVideoDisc(
                "Broken Trailer Cut", "Movie", "Unknown Director", 0, 1.2f);

        CompactDisc thriller = new CompactDisc(
                "Thriller", "Music", "Michael Jackson", "Quincy Jones", 0, 4.2f);
        thriller.addTrack(new Track("Beat It", 4));
        thriller.addTrack(new Track("Billie Jean", 5));

        CompactDisc randomAccessMemories = new CompactDisc(
                "Random Access Memories", "Music", "Daft Punk", "Daft Punk", 0, 5.1f);
        randomAccessMemories.addTrack(new Track("Give Life Back to Music", 4));
        randomAccessMemories.addTrack(new Track("Get Lucky", 6));

        CompactDisc invalidCd = new CompactDisc(
                "Silent Sessions", "Music", "Test Artist", "Test Director", 0, 2.0f);

        CompactDisc invalidTrackCd = new CompactDisc(
                "Glitch Tape", "Music", "Debug Band", "Studio Null", 0, 2.6f);
        invalidTrackCd.addTrack(new Track("Boot Sequence", 3));
        invalidTrackCd.addTrack(new Track("Corrupted Frame", 0));

        Book cleanCode = new Book("Clean Code", "Programming", 7.5f);
        Book dune = new Book("Dune", "Science Fiction", 4.4f);
        Book greenEggsAndHam = new Book("Green Eggs and Ham", "Children", 3.3f);

        store.addMedia(interstellar);
        store.addMedia(spiderVerse);
        store.addMedia(invalidDvd);
        store.addMedia(thriller);
        store.addMedia(randomAccessMemories);
        store.addMedia(invalidCd);
        store.addMedia(invalidTrackCd);
        store.addMedia(cleanCode);
        store.addMedia(dune);
        store.addMedia(greenEggsAndHam);

        launch(args);
    }
}
