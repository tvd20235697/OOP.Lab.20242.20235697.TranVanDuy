package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Arrays;

public class CartTest {
    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart cart = new Cart();

        // Tạo đối tượng DigitalVideoDisc và thêm vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        // Tạo đối tượng Book và thêm vào giỏ hàng
        Book book1 = new Book(2, "Harry Potter", "Fantasy", 25.99f, new ArrayList<String>(Arrays.asList("J.K. Rowling")));
        cart.addMedia(book1);

        // Tạo đối tượng CompactDisc và thêm các Track vào CD
        CompactDisc cd1 = new CompactDisc(3, "The Best Hits", "Music", 14.99f, "John Doe", "Artist Name", 60);
        Track track1 = new Track("Track 1", 3);
        Track track2 = new Track("Track 2", 4);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cart.addMedia(cd1);

        // Hiển thị thông tin giỏ hàng
        cart.displayCart();

        // Test thêm và xóa các media trong giỏ hàng
        cart.removeMedia(dvd1);
        System.out.println("Total cost after removal: " + cart.totalCost());
    }
}