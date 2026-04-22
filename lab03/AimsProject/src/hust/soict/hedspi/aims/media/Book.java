package hust.soict.hedspi.aims.media;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Object;
public class Book extends Media{

    private ArrayList<String> authors = new ArrayList<>();

    public Book() {
        super();
    }
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author " + authorName + " has been added.");
        } else {
            System.out.println("Author " + authorName + " has been extinct in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " has been deleted.");
        } else {
            System.out.println("Not found " + authorName + " to delete.");
        }
    }

    @Override
    public String toString() {
        return "Book - " + super.toString() + ": " + getCost() + " $";
    }

}
