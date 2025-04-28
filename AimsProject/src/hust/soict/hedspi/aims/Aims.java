package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo cửa hàng và giỏ hàng
        Store store = new Store();
        Cart cart = new Cart();

        // Thêm vài media vào cửa hàng (có thể thêm bằng tay hoặc tự động)
        initializeStore(store);

        // Sử dụng getItemsInStore() để truy xuất danh sách
        ArrayList<Media> items = store.getItemsInStore();
        
        // In danh sách media trong store
        System.out.println("Danh sách sản phẩm trong store:");
        for (Media item : items) {
            System.out.println(item.getTitle()); // Giả sử Media có phương thức getTitle()
        }

        // Hiển thị menu chính và xử lý lựa chọn của người dùng
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ newline

            switch (choice) {
                case 1:
                    viewStore(store, cart, scanner); // Xem cửa hàng
                    break;
                case 2:
                    updateStore(store, scanner); // Cập nhật cửa hàng
                    break;
                case 3:
                    seeCurrentCart(cart, scanner); // Xem giỏ hàng
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        }
        scanner.close();
    }

    // Hiển thị menu chính
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. Xem cửa hàng");
        System.out.println("2. Cập nhật cửa hàng");
        System.out.println("3. Xem giỏ hàng hiện tại");
        System.out.println("0. Thoát");
        System.out.println("--------------------------------");
        System.out.print("Hãy chọn 1 số: 0-1-2-3: ");
    }

    // Khởi tạo một số sản phẩm trong cửa hàng
    public static void initializeStore(Store store) {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        ArrayList<String> authors = new ArrayList<>(); 
        authors.add("J.K. Rowling");
        store.addMedia(new Book(2, "Harry Potter", "Fantasy", 25.99f, authors));
        CompactDisc cd1 = new CompactDisc(3, "The Best Hits", "Music", 14.99f, "John Doe", "Artist Name", 60);
        cd1.addTrack(new Track("Track 1", 3));
        cd1.addTrack(new Track("Track 2", 4));
        store.addMedia(cd1);
    }

    // Xem cửa hàng và xử lý menu cho cửa hàng
    public static void viewStore(Store store, Cart cart, Scanner scanner) {
        boolean inStore = true;
        while (inStore) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ newline

            switch (choice) {
                case 1:
                    System.out.print("Nhập tiêu đề của phương tiện truyền thông: ");
                    String title = scanner.nextLine();
                    store.displayMediaDetails(title);
                    break;
                case 2:
                    System.out.print("Nhập tiêu đề của media để thêm vào cart: ");
                    title = scanner.nextLine();
                    store.addToCart(title, cart);
                    break;
                case 3:
                    System.out.print("Nhập tiêu đề của media để play: ");
                    title = scanner.nextLine();
                    store.playMedia(title);
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 0:
                    inStore = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        }
    }

    // Menu cửa hàng
    public static void storeMenu() {
        System.out.println("Lựa chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Xem chi tiết phương tiện ");
        System.out.println("2. Thêm phương tiện vào giỏ hàng");
        System.out.println("3. Phát phương tiện");
        System.out.println("4. Xem giỏ hàng hiện tại");
        System.out.println("0. Trở lại");
        System.out.println("--------------------------------");
        System.out.print("Hãy chọn 1 số: 0-1-2-3-4: ");
    }

    // Cập nhật cửa hàng (thêm hoặc xóa media)
    public static void updateStore(Store store, Scanner scanner) {
        boolean inUpdate = true;
        while (inUpdate) {
            System.out.println("Lựa chọn: ");
            System.out.println("1. Thêm phương tiện vào cửa hàng");
            System.out.println("2. Xóa phương tiện khỏi cửa hàng");
            System.out.println("0. Trở lại");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ newline

            switch (choice) {
                case 1:
                    // Thêm media vào cửa hàng (có thể làm với các loại media cụ thể như DVD, CD, Book)
                	System.out.print("Nhập loại media (DVD, Book, CD): ");
                	String mediaType = scanner.nextLine();
                	if ("DVD".equalsIgnoreCase(mediaType)) {
                	    System.out.print("Nhập tiêu đề: ");
                	    String title = scanner.nextLine();
                	    System.out.print("Nhập đạo diễn: ");
                	    String director = scanner.nextLine();
                	    System.out.print("Nhập độ dài: ");
                	    int length = scanner.nextInt();
                	    System.out.print("Nhập giá: ");
                	    float cost = scanner.nextFloat();
                	    store.addMedia(new DigitalVideoDisc(title, "Thể loại", director, length, cost));
                	} else if ("Book".equalsIgnoreCase(mediaType)) {
                	    // Thêm sách vào cửa hàng
                	    System.out.print("Nhập tiêu đề sách: ");
                	    String title = scanner.nextLine();
                	    System.out.print("Nhập thể loại sách: ");
                	    String genre = scanner.nextLine();
                	    System.out.print("Nhập giá sách: ");
                	    float cost = scanner.nextFloat();
                	    scanner.nextLine();  // Đọc bỏ newline sau khi nhập giá
                	    System.out.print("Nhập tên tác giả: ");
                	    String author = scanner.nextLine();
                	    ArrayList<String> authors = new ArrayList<>();
                	    authors.add(author);
                	    store.addMedia(new Book(2, title, genre, cost, authors));
                	} else if ("CD".equalsIgnoreCase(mediaType)) {
                	    // Thêm CD vào cửa hàng
                	    System.out.print("Nhập tiêu đề CD: ");
                	    String title = scanner.nextLine();
                	    System.out.print("Nhập thể loại CD: ");
                	    String genre = scanner.nextLine();
                	    System.out.print("Nhập giá CD: ");
                	    float cost = scanner.nextFloat();
                	    scanner.nextLine();  // Đọc bỏ newline
                	    System.out.print("Nhập tên nghệ sĩ: ");
                	    String artist = scanner.nextLine();
                	    System.out.print("Nhập số lượng bài hát: ");
                	    int numberOfTracks = scanner.nextInt();
                	    scanner.nextLine();  // Đọc bỏ newline

                	    CompactDisc cd = new CompactDisc(3, title, genre, cost, "John Doe", artist, numberOfTracks);
                	    for (int i = 1; i <= numberOfTracks; i++) {
                	        System.out.print("Nhập tên bài hát " + i + ": ");
                	        String trackTitle = scanner.nextLine();
                	        System.out.print("Nhập thời gian bài hát " + i + " (phút): ");
                	        int trackLength = scanner.nextInt();
                	        scanner.nextLine();  // Đọc bỏ newline
                	        cd.addTrack(new Track(trackTitle, trackLength));
                	    }
                	    store.addMedia(cd);
                	} else {
                	    System.out.println("Loại media không hợp lệ. Vui lòng thử lại.");
                	}
                    break;
                case 2:
                    // Xóa media khỏi cửa hàng
                    System.out.print("Nhập tiêu đề của phương tiện truyền thông để xóa: ");
                    String titleToRemove = scanner.nextLine();
                    store.removeMedia(titleToRemove);
                    break;
                case 0:
                    inUpdate = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        }
    }

    // Xem giỏ hàng và xử lý menu giỏ hàng
    public static void seeCurrentCart(Cart cart, Scanner scanner) {
        boolean inCart = true;
        while (inCart) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ newline

            switch (choice) {
                case 1:
                    System.out.print("Lọc phương tiện theo (id/title): ");
                    String filterBy = scanner.nextLine();
                    cart.filterMedia(filterBy);
                    break;
                case 2:
                    System.out.print("Sắp xếp phương tiện theo (title/cost): ");
                    String sortBy = scanner.nextLine();
                    cart.sortMedia(sortBy);
                    break;
                case 3:
                    System.out.print("Nhập tiêu đề phương tiện để xóa: ");
                    String titleToRemove = scanner.nextLine();
                    cart.removeMediaByTitle(titleToRemove);
                    break;
                case 4:
                    System.out.print("Nhập tiêu đề của phương tiện truyền thông để phát: ");
                    String titleToPlay = scanner.nextLine();
                    cart.playMedia(titleToPlay);
                    break;
                case 5:
                    cart.placeOrder();
                    break;
                case 0:
                    inCart = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        }
    }

    // Menu giỏ hàng
    public static void cartMenu() {
        System.out.println("Lựa chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1.Lọc phương tiện trong giỏ hàng");
        System.out.println("2.Sắp xếp phương tiện trong giỏ hàng");
        System.out.println("3.Xóa phương tiện khỏi giỏ hàng");
        System.out.println("4. Phát phương tiện");
        System.out.println("5. Đặt hàng");
        System.out.println("0. Trở lại");
        System.out.println("--------------------------------");
        System.out.print("Hãy chọn 1 số: 0-1-2-3-4-5: ");
    }
}