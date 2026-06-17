package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;
import java.util.Scanner;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);
    private static void seedStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Science Fiction", "Lana Wachowski", 136, 24.95f);

        Book book1 = new Book();
        book1.setTitle("Clean Code");
        book1.setCategory("Programming");
        book1.setCost(29.99f);
        book1.addAuthor("Robert C. Martin");

        Book book2 = new Book();
        book2.setTitle("Design Patterns");
        book2.setCategory("Programming");
        book2.setCost(35.50f);
        book2.addAuthor("Erich Gamma");
        book2.addAuthor("Richard Helm");

        Book book3 = new Book();
        book3.setTitle("The Great Gatsby");
        book3.setCategory("Classic");
        book3.setCost(15.00f);
        book3.addAuthor("F. Scott Fitzgerald");

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", "Quincy Jones", 0, 20.0f);
        cd1.addTrack(new Track("Beat It", 4));
        cd1.addTrack(new Track("Billie Jean", 5));

        CompactDisc cd2 = new CompactDisc("Abbey Road", "Rock", "The Beatles", "George Martin", 0, 25.0f);
        cd2.addTrack(new Track("Come Together", 4));
        cd2.addTrack(new Track("Something", 3));
        cd2.addTrack(new Track("Maxwell's Silver Hammer", 3));

        CompactDisc cd3 = new CompactDisc("Random Access Memories", "Electronic", "Daft Punk", "Daft Punk", 0, 22.5f);
        cd3.addTrack(new Track("Get Lucky", 6));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
    }

    public static void main(String[] args) {
        seedStore();
        while (true) {
            showMenu();
            int choice = readInt();

            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void viewStore() {
        while (true) {
            store.printStore();
            storeMenu();

            int choice = readInt();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Please enter the title of the media: ");
                    String titleDetails = scanner.nextLine();
                    Media foundMedia = store.search(titleDetails);
                    if (foundMedia != null) {
                        System.out.println(foundMedia.toString());
                        handleMediaDetailsMenu(foundMedia);
                    } else {
                        System.out.println("No media found with title: " + titleDetails);
                    }
                    break;

                case 2:
                    System.out.print("Please enter the title of the media to add to cart: ");
                    String titleAdd = scanner.nextLine();
                    Media mediaToAdd = store.search(titleAdd);
                    if (mediaToAdd != null) {
                        cart.addMedia(mediaToAdd);
                        if (mediaToAdd instanceof DigitalVideoDisc) {
                            System.out.println("Number of DVDs in cart: " + cart.countDvds());
                        }
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;

                case 3:
                    System.out.print("Please enter the title to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaToPlay = store.search(titlePlay);
                    if (mediaToPlay != null) {
                        if (mediaToPlay instanceof Playable) {
                            ((Playable) mediaToPlay).play();
                        } else {
                            System.out.println("This media type is not playable (Books cannot be played).");
                        }
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;

                case 4:
                    viewCart();
                    break;

                default:
                    System.out.println("Invalid choice. Please choose 0-4.");
                    break;
            }
        }
    }
    public static void handleMediaDetailsMenu(Media media) {
        while (true) {
            mediaDetailsMenu(media);
            int choice = readInt();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    if (media instanceof DigitalVideoDisc) {
                        System.out.println("Number of DVDs in cart: " + cart.countDvds());
                    }
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof Playable) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print(media instanceof Playable
                ? "Please choose a number: 0-1-2: "
                : "Please choose a number: 0-1: ");
    }
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void updateStore() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");

            int choice = readInt();
            if (choice == 0) {
                return;
            }

            switch (choice) {
                case 1:
                    Media media = createMediaFromInput();
                    if (media != null) {
                        store.addMedia(media);
                    }
                    break;
                case 2:
                    System.out.print("Please enter the title of the media to remove: ");
                    String title = scanner.nextLine().trim();
                    Media mediaToRemove = store.search(title);
                    if (mediaToRemove != null) {
                        store.removeMedia(mediaToRemove);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-1-2.");
            }
        }
    }

    public static void viewCart() {
        while (true) {
            cart.printItems();
            cartMenu();
            int choice = readInt();

            if (choice == 0) {
                return;
            }

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    System.out.print("Please enter the title of the media to remove: ");
                    String title = scanner.nextLine().trim();
                    Media mediaToRemove = cart.findByTitle(title);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                    } else {
                        System.out.println("Media not found in cart!");
                    }
                    break;
                case 4:
                    System.out.print("Please enter the title of the media to play: ");
                    String playTitle = scanner.nextLine().trim();
                    Media mediaToPlay = cart.findByTitle(playTitle);
                    if (mediaToPlay == null) {
                        System.out.println("Media not found in cart!");
                    } else if (mediaToPlay instanceof Playable) {
                        ((Playable) mediaToPlay).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 5:
                    System.out.println("An order has been created.");
                    cart.empty();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-1-2-3-4-5.");
            }
        }
    }

    private static void filterCart() {
        System.out.println("Filter options:");
        System.out.println("1. By id");
        System.out.println("2. By title");
        System.out.print("Please choose a number: 1-2: ");
        int choice = readInt();

        switch (choice) {
            case 1:
                System.out.print("Please enter media id: ");
                cart.searchById(readInt());
                break;
            case 2:
                System.out.print("Please enter media title: ");
                cart.searchByTitle(scanner.nextLine().trim());
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void sortCart() {
        System.out.println("Sort options:");
        System.out.println("1. By title");
        System.out.println("2. By cost");
        System.out.print("Please choose a number: 1-2: ");
        int choice = readInt();

        switch (choice) {
            case 1:
                cart.sortByTitle();
                System.out.println("The cart has been sorted by title then cost.");
                break;
            case 2:
                cart.sortByCost();
                System.out.println("The cart has been sorted by cost then title.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static Media createMediaFromInput() {
        System.out.println("Media types:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.print("Please choose a number: 1-2-3: ");
        int type = readInt();

        switch (type) {
            case 1:
                return createBook();
            case 2:
                return createDvd();
            case 3:
                return createCd();
            default:
                System.out.println("Invalid choice.");
                return null;
        }
    }

    private static Book createBook() {
        Book book = new Book();
        System.out.print("Title: ");
        book.setTitle(scanner.nextLine().trim());
        System.out.print("Category: ");
        book.setCategory(scanner.nextLine().trim());
        System.out.print("Cost: ");
        book.setCost(readFloat());
        System.out.print("Number of authors: ");
        int authorCount = readInt();
        for (int i = 0; i < authorCount; i++) {
            System.out.print("Author " + (i + 1) + ": ");
            book.addAuthor(scanner.nextLine().trim());
        }
        return book;
    }

    private static DigitalVideoDisc createDvd() {
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Category: ");
        String category = scanner.nextLine().trim();
        System.out.print("Director: ");
        String director = scanner.nextLine().trim();
        System.out.print("Length: ");
        int length = readInt();
        System.out.print("Cost: ");
        float cost = readFloat();
        return new DigitalVideoDisc(title, category, director, length, cost);
    }

    private static CompactDisc createCd() {
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Category: ");
        String category = scanner.nextLine().trim();
        System.out.print("Artist: ");
        String artist = scanner.nextLine().trim();
        System.out.print("Director: ");
        String director = scanner.nextLine().trim();
        System.out.print("Cost: ");
        float cost = readFloat();

        CompactDisc cd = new CompactDisc(title, category, artist, director, 0, cost);
        System.out.print("Number of tracks: ");
        int trackCount = readInt();
        for (int i = 0; i < trackCount; i++) {
            System.out.print("Track " + (i + 1) + " title: ");
            String trackTitle = scanner.nextLine().trim();
            System.out.print("Track " + (i + 1) + " length: ");
            int trackLength = readInt();
            cd.addTrack(new Track(trackTitle, trackLength));
        }
        return cd;
    }



    private static int readInt() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.print("Invalid number. Please enter again: ");
            }
        }
    }

    private static float readFloat() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException exception) {
                System.out.print("Invalid number. Please enter again: ");
            }
        }
    }
}
