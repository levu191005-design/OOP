
public class DigitalVideoDisc {
    private int id;
    private static int nbDigitalVideoDiscs = 0;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private float mass;

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }


    //title

    public DigitalVideoDisc(String title) {
        this.title = title;
        //update attribute
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    // category, title and cost

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        //update attribute
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }


    // director, category, title and cost

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        //update attribute
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }


    //all


    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        // update attribute
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost, float mass) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.mass = mass;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }
}
