package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfArtist, tfDirector;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD to Store");

        JPanel centerPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        centerPanel.add(new JLabel("Title: "));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category: "));
        tfCategory = new JTextField();
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost ($): "));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        centerPanel.add(new JLabel("Artist: "));
        tfArtist = new JTextField();
        centerPanel.add(tfArtist);

        centerPanel.add(new JLabel("Director: "));
        tfDirector = new JTextField();
        centerPanel.add(tfDirector);

        JButton btnAdd = new JButton("Add CD");

        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String artist = tfArtist.getText();
            String director = tfDirector.getText();

            CompactDisc cd = new CompactDisc(title, category, director, artist, cost);

            this.store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "Compact Disc added successfully!");

            new StoreManagerScreen(store);
            this.dispose();
        });

        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(btnAdd, BorderLayout.SOUTH);
        setVisible(true);
    }
}