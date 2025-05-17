package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen mainScreen) {
        super(store, mainScreen);
        buildForm();
    }

    @Override
    protected void buildForm() {
        JPanel panel = new JPanel(new GridLayout(7, 2));
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField artistField = new JTextField();
        JTextField lengthField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        panel.add(new JLabel("Artist:"));
        panel.add(artistField);
        panel.add(new JLabel("Length:"));
        panel.add(lengthField);

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            String director = directorField.getText();
            String artist = artistField.getText();
            int length = Integer.parseInt(lengthField.getText());

            store.addCompactDisc(id, title, category, cost, director, artist, length);
            JOptionPane.showMessageDialog(this, "CD added to store!");
        });

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(addButton, BorderLayout.SOUTH);
    }
}