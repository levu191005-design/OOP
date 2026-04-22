package hust.soict.hedspi.aims.media;

import org.w3c.dom.html.HTMLImageElement;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    //title

    public DigitalVideoDisc(String title) {
        super(title);
        //update attribute
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    // category, title and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        //update attribute
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    // director, category, title and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category,director, cost);
        //update attribute
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    //all
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        // update attribute
        nbDigitalVideoDiscs++;
       this.setId(nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }
    // Trong file DigitalVideoDisc.java
    @Override
    public String toString() {
        return "DVD - " + super.toString() + " - "
                + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
