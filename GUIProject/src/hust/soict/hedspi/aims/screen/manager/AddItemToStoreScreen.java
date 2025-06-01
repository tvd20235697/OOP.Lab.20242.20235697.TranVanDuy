package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected StoreManagerScreen mainScreen;

    public AddItemToStoreScreen(Store store, StoreManagerScreen mainScreen) {
        this.store = store;
        this.mainScreen = mainScreen;

        setTitle("Add Item to Store");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(mainScreen.createMenuBar(), BorderLayout.NORTH);
    }

    protected abstract void buildForm();
}