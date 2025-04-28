package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class Store {
    // Dùng ArrayList thay vì mảng tĩnh
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

    // Hiển thị danh sách media trong cửa hàng
    public void displayMediaDetails(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                media.displayInfo();
                return;
            }
        }
        System.out.println("Media not found in store.");
    }
    public void addToCart(String title, Cart cart) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                cart.addMedia(media);
                return;
            }
        }
        System.out.println("Media not found in store.");
    }
    public void playMedia(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title) && media instanceof Playable) {
                ((Playable) media).play();
                return;
            }
        }
        System.out.println("Playable media not found with title: " + title);
    }



    // Getter để truy xuất danh sách nếu cần
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}