package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        menu.add(new JMenuItem("View store"));

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> { new AddBookToStoreScreen(store); this.dispose(); });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> { new AddCompactDiscToStoreScreen(store); this.dispose(); });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            this.dispose();
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = (ArrayList<Media>) store.getItemsInStore();
        int limit = Math.min(9, mediaInStore.size());

        for (int i = 0; i < limit; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }
    private class MediaStore extends JPanel {
        public MediaStore(Media media) {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
            title.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel cost = new JLabel("" + media.getCost() + " $");
            cost.setFont(new Font(cost.getFont().getName(), Font.PLAIN, 15));
            cost.setAlignmentX(Component.CENTER_ALIGNMENT);
            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));
            if (media instanceof Playable) {
                JButton playButton = new JButton("Play");
                container.add(playButton);
                playButton.addActionListener(e -> {
                    JOptionPane.showMessageDialog(StoreManagerScreen.this,
                            "Playing media: " + media.getTitle(),
                            "AIMS Player",
                            JOptionPane.INFORMATION_MESSAGE);
                });
            }
            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);
            this.add(Box.createVerticalGlue());

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
    public static void main(String[] args) {
        Store mockStore = new Store();

        mockStore.addMedia(new DigitalVideoDisc("Harry Potter and the Philosopher's Stone (2001)", "Animation", 3.0f));
        mockStore.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets (2002)", "Animation", 3.5f));
        mockStore.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban (2004)", "Animation", 5.0f));

        mockStore.addMedia(new DigitalVideoDisc("Harry Potter and the Goblet of Fire (2005)", "Animation", 4.5f));
        mockStore.addMedia(new DigitalVideoDisc("Fetch the Bolt Cutters", "Music", 10.39f));
        mockStore.addMedia(new DigitalVideoDisc("Future Nostalgia", "Music", 9.6f));

        mockStore.addMedia(new DigitalVideoDisc("The Hunger Games", "Movie", 5.5f));
        mockStore.addMedia(new DigitalVideoDisc("Catching Fire", "Movie", 4.9f));
        mockStore.addMedia(new DigitalVideoDisc("Mockingjay", "Movie", 5.1f));

        new StoreManagerScreen(mockStore);
    }
}
