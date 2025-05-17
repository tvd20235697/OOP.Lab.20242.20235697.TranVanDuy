package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });

        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> new AddBookToStoreScreen(store, this));

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store, this));

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store, this));

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
        center.setLayout(new GridLayout(3, 3, 10, 10));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    public StoreManagerScreen(Store store) {
        super();
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    	Store store = new Store();

        // Add sample books
        ArrayList<String> bookAuthors1 = new ArrayList<>();
        bookAuthors1.add("J.K. Rowling");
        store.addBook(1, "Harry Potter and the Philosopher's Stone", "Fantasy", 3.0f, bookAuthors1);

        ArrayList<String> bookAuthors2 = new ArrayList<>();
        bookAuthors2.add("J.K. Rowling");
        store.addBook(2, "Harry Potter and the Chamber of Secrets", "Fantasy", 3.5f, bookAuthors2);

        ArrayList<String> bookAuthors3 = new ArrayList<>();
        bookAuthors3.add("J.K. Rowling");
        store.addBook(3, "Harry Potter and the Prisoner of Azkaban", "Fantasy", 6.0f, bookAuthors3);

        ArrayList<String> bookAuthors4 = new ArrayList<>();
        bookAuthors4.add("J.K. Rowling");
        store.addBook(4, "Harry Potter and the Goblet of Fire", "Fantasy", 4.5f, bookAuthors4);

        ArrayList<String> bookAuthors5 = new ArrayList<>();
        bookAuthors5.add("Suzanne Collins");
        store.addBook(5, "The Hunger Games", "Dystopian", 5.5f, bookAuthors5);

        ArrayList<String> bookAuthors6 = new ArrayList<>();
        bookAuthors6.add("Suzanne Collins");
        store.addBook(6, "Catching Fire", "Dystopian", 4.9f, bookAuthors6);

        ArrayList<String> bookAuthors7 = new ArrayList<>();
        bookAuthors7.add("Suzanne Collins");
        store.addBook(7, "Mockingjay", "Dystopian", 5.1f, bookAuthors7);

        // Add sample CDs
        store.addCompactDisc(8, "Fetch the Bolt Cutters", "Alternative", 10.39f, "Unknown Director", "Fiona Apple", 52);

        // Add sample DVDs
        store.addDigitalVideoDisc("Future Nostalgia", "Pop", "Unknown Director", 45, 9.6f);

        // Launch the store manager screen with the populated store
        new StoreManagerScreen(store);
    }
}
