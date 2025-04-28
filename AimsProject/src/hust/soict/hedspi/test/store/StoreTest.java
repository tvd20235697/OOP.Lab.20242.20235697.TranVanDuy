package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo cửa hàng mới
        Store store = new Store();

        // Tạo các DVD và thêm chúng vào cửa hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addDVD(dvd3);

        // Hiển thị thông tin các DVD trong cửa hàng
        store.displayStore();

        // Kiểm tra xóa DVD khỏi cửa hàng
        System.out.println("\nTest remove DVD:");
        store.removeDVD(dvd2);  // Xóa DVD "Star Wars"
        store.displayStore();  // Hiển thị lại cửa hàng

        // Kiểm tra xóa DVD không có trong cửa hàng
        System.out.println("\nTest remove DVD not in store:");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Lana Wachowski", 136, 19.99f);
        store.removeDVD(dvd4);  // DVD "The Matrix" không có trong cửa hàng
        store.displayStore();  // Hiển thị lại cửa hàng
    }
}