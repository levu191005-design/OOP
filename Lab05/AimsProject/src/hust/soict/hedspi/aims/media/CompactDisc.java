package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String beatIt, String pop, float v) {
        super(beatIt, pop, v);
    }

    public String getArtist() { return artist; }

    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, director, cost);
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
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
            System.out.println("Total length: " + this.getLength());
            System.out.println("Detailed tracks:");

            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException exception) {
                    System.err.println(exception.getMessage());
                    System.err.println(exception.toString());
                    exception.printStackTrace();
                    throw exception;
                }
            }
        } else {
            String message = "ERROR: CD length is non-positive!";
            System.err.println(message);
            throw new PlayerException(message);
        }
    }
    @Override
    public String toString() {
        return "CD - " + super.toString() + " - "
                + getDirector() + " - " + artist + " - "
                + getLength() + " mins: " + getCost() + " $";
    }
}
