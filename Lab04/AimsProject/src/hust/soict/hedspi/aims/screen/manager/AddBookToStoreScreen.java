package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
        JPanel centerPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        centerPanel.add(new JLabel("Title: "));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category: "));
        tfCategory = new JTextField();
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost ($): "));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        centerPanel.add(new JLabel("Authors (separated by comma): "));
        tfAuthors = new JTextField();
        centerPanel.add(tfAuthors);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String authorsInput = tfAuthors.getText();
            Book book = new Book(title, category, cost);

            if (!authorsInput.trim().isEmpty()) {
                String[] authorsArray = authorsInput.split(",");
                for (String author : authorsArray) {
                    book.addAuthor(author.trim());
                }
            }

            this.store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");

            new StoreManagerScreen(store);
            this.dispose();
        });

        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(btnAdd, BorderLayout.SOUTH);
        setVisible(true);
    }
}