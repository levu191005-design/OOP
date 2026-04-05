
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("added successfully");
        } else {
            System.out.println("Error");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i] == disc) {
                for(int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("removed successfully");
                return;
            }
        }
        System.out.println("the list is not contain element");
    }

    public float totalCost() {
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i] != null) {
                total += itemsOrdered[i].getCost();
            }
        }
        return total;
    }

    public void printItems() {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i] != null) {
                System.out.println(i + "\t" + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost());
            }

        }
    }
    // overloading
    // use list to add
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" added successfully");
            } else {
                System.out.println("full!");
                break;
            }
        }
    }

    // two elements
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    public void searchById(int id) {

    }
    public void searchByTitle(String title) {

    }

    public void sortByTitle() {

    }
    public void sortByCost() {

    }
    public void getFreeItem() {

    }
}
