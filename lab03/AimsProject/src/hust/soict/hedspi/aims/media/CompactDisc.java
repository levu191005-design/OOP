package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public String getArtist() { return artist; }

    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " has been extinct in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track has been added: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track has been removed: " + track.getTitle());
        } else {
            System.out.println("Track " + track.getTitle() + " is not extinct in the list.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        System.out.println("Total length: " + this.getLength());
        System.out.println("Detailed tracks:");

        for (Track track : tracks) {
            track.play();
        }
    }
    @Override
    public String toString() {
        return "CD - " + super.toString() + " - "
                + getDirector() + " - " + artist + " - "
                + getLength() + " mins: " + getCost() + " $";
    }
}