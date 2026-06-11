package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");

        JPanel centerPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        centerPanel.add(new JLabel("Title: "));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category: "));
        tfCategory = new JTextField();
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost ($): "));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
            this.store.addMedia(dvd);

            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            new StoreManagerScreen(store);
            this.dispose();
        });

        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(btnAdd, BorderLayout.SOUTH);
        setVisible(true);
    }
}
