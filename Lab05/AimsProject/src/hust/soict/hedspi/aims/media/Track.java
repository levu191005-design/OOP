package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            String message = "ERROR: Track length is non-positive!";
            System.err.println(message);
            throw new PlayerException(message);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;

        return this.length == other.getLength() &&
                this.title != null &&
                this.title.equalsIgnoreCase(other.getTitle());
    }
}
