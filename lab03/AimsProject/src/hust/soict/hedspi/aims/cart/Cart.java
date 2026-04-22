package hust.soict.hedspi.aims.cart;


import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The media \"" + media.getTitle() + "\" added successfully");
            } else {
                System.out.println("The media \"" + media.getTitle() + "\" is already in the cart.");
            }
        } else {
            System.out.println("The cart is full!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" removed successfully");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media item : itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    public void printItems() {
        System.out.println("***********************CART***********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Ordered Items:");
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
            }
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                System.out.println("Found match for ID " + id + ": " + item.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media with ID: " + id + " was found.");
        }
    }
    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("Search results for title '" + title + "':");
        for (Media item : itemsOrdered) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("- " + item.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with title: '" + title + "' was found.");
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    public void getFreeItem() {

    }

    public Media findByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public int countDvds() {
        int count = 0;
        for (Media item : itemsOrdered) {
            if (item instanceof hust.soict.hedspi.aims.media.DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }

    public void empty() {
        itemsOrdered.clear();
    }

    public List<Media> getItemsOrdered() {
        return new ArrayList<>(itemsOrdered);
    }
}
