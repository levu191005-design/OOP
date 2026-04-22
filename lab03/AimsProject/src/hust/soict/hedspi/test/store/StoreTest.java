package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store aimsStore = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book1 = new Book();
        book1.setTitle("Java Programming");
        book1.setCategory("Education");
        book1.setCost(15.5f);
        book1.addAuthor("James Gosling");

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", "Quincy Jones", 42, 20.0f);

        System.out.println("--- Thêm các mặt hàng vào kho ---");
        aimsStore.addMedia(dvd1);
        aimsStore.addMedia(book1);
        aimsStore.addMedia(cd1);

        aimsStore.printStore();

        System.out.println("--- Xóa mặt hàng (book1) ---");
        aimsStore.removeMedia(book1);
        aimsStore.printStore();

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Sci-fi", "James Cameron", 162, 25.0f);
        aimsStore.removeMedia(dvd4);
    }
}