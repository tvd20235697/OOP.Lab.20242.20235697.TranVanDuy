package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // Thêm media vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Media \"" + media.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("Media \"" + media.getTitle() + "\" is already in the store.");
        }
    }

    // Thêm sách vào cửa hàng
    public void addBook(int id, String title, String category, float cost, ArrayList<String> authors) {
        Book book = new Book(id, title, category, cost, authors);
        addMedia(book);
    }

    // Thêm đĩa CD vào cửa hàng
    public void addCompactDisc(int id, String title, String category, float cost, String director, String artist, int length) {
        CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist, length);
        addMedia(cd);
    }

    // Thêm đĩa DVD vào cửa hàng
    public void addDigitalVideoDisc(String title, String category, String director, int length, float cost) {
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        addMedia(dvd);
    }

    // Xoá media khỏi cửa hàng
    public void removeMedia(String title) {
        Media mediaToRemove = null;
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                mediaToRemove = media;
                break;
            }
        }
        if (mediaToRemove != null) {
            itemsInStore.remove(mediaToRemove);
            System.out.println(title + " has been removed from the store.");
        } else {
            System.out.println("No media found with the title: " + title);
        }
    }

    // Hiển thị thông tin chi tiết của media
    public void displayMediaDetails(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                media.displayInfo();
                return;
            }
        }
        System.out.println("Media not found in store.");
    }

    // Thêm media vào giỏ hàng
    public void addToCart(String title, Cart cart) throws LimitExceededException {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                cart.addMedia(media);
                return;
            }
        }
        System.out.println("Media not found in store.");
    }

    // Phát media nếu có thể
    public void playMedia(String title) throws PlayerException {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title) && media instanceof Playable) {
                ((Playable) media).play();
                return;
            }
        }
        System.out.println("Playable media not found with title: " + title);
    }

    // Getter để truy xuất danh sách media trong cửa hàng
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
