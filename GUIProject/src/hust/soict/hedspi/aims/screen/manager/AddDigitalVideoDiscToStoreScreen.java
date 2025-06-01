package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store, StoreManagerScreen mainScreen) {
        super(store, mainScreen);
        buildForm();
    }

    @Override
    protected void buildForm() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField lengthField = new JTextField();
        JTextField costField = new JTextField();

        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        panel.add(new JLabel("Length:"));
        panel.add(lengthField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());
            float cost = Float.parseFloat(costField.getText());

            store.addDigitalVideoDisc(title, category, director, length, cost);
            JOptionPane.showMessageDialog(this, "DVD added to store!");
        });

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(addButton, BorderLayout.SOUTH);
    }
}
