package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd);

        Book book = new Book();
        book.setTitle("Java Programming");
        book.setCategory("Technology");
        book.setCost(15.5f);
        book.addAuthor("James Gosling");
        cart.addMedia(book);

        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Michael Jackson", "Quincy Jones", 42, 20.0f);
        cd.addTrack(new Track("Beat It", 4));
        cd.addTrack(new Track("Billie Jean", 5));
        cart.addMedia(cd);

        cart.printItems();
    }
}