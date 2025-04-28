package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class Cart {
    // Sử dụng ArrayList để lưu trữ các đối tượng Media
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {  // Kiểm tra xem media đã tồn tại trong giỏ hàng chưa
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added.");
        } else {
            System.out.println(media.getTitle() + " is already in the cart.");
        }
    }
    

    // Xóa đối tượng Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    // Hiển thị thông tin giỏ hàng
    public void displayCart() {
        System.out.println("***********************CART***********************");
        float totalcost = 0;
        
        // Duyệt qua các đối tượng trong giỏ hàng và in thông tin chi tiết
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            media.displayInfo(); // Hiển thị thông tin Media
            totalcost += media.getCost();
        }
        
        System.out.println("Total cost: " + Math.round(totalcost * 100.0) / 100.0 + "$");
        System.out.println("The number of items in the cart is: " + itemsOrdered.size());
        System.out.println("**************************************************");
    }

    // Tính tổng chi phí của tất cả các đối tượng trong giỏ hàng
    public float totalCost() {
        float total = 0;
        // Duyệt qua các đối tượng trong giỏ hàng và tính tổng chi phí
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Tìm kiếm theo tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
        // Duyệt qua các đối tượng trong giỏ hàng để tìm kiếm theo tiêu đề
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found media with title \"" + title + "\": " + media.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title \"" + title + "\"");
        }
    }

    // Tìm kiếm theo ID
    public void searchById(int id) {
        boolean found = false;
        // Duyệt qua các đối tượng trong giỏ hàng để tìm kiếm theo ID
        for (Media media : itemsOrdered) {
            if (media.isMatch(id)) {
                System.out.println("Found media with ID " + id + ": " + media.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with ID " + id);
        }
    }

    // Sắp xếp giỏ hàng theo tiêu đề và chi phí
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST); // Sắp xếp theo tiêu đề và chi phí
        System.out.println("Cart sorted by Title and Cost:");
        displayCart();
    }

    // Sắp xếp giỏ hàng theo chi phí và tiêu đề
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE); // Sắp xếp theo chi phí và tiêu đề
        System.out.println("Cart sorted by Cost and Title:");
        displayCart();
    }

    // Phương thức lọc media trong giỏ hàng theo ID hoặc tiêu đề
public void filterMedia(String filterBy) {
    if ("id".equalsIgnoreCase(filterBy)) {
        // Lọc theo ID
        System.out.print("Enter ID to filter: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        searchById(id);
    } else if ("title".equalsIgnoreCase(filterBy)) {
        // Lọc theo tiêu đề
        System.out.print("Enter title to filter: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        searchByTitle(title);
    } else {
        System.out.println("Invalid filter option. Please try again.");
    }
}
   // Phương thức sắp xếp media trong giỏ hàng theo tiêu đề hoặc chi phí
public void sortMedia(String sortBy) {
    if ("title".equalsIgnoreCase(sortBy)) {
        sortByTitleCost();
    } else if ("cost".equalsIgnoreCase(sortBy)) {
        sortByCostTitle();
    } else {
        System.out.println("Invalid sort option. Please try again.");
    }
}
    // Phương thức xóa media khỏi giỏ hàng theo tiêu đề
public void removeMediaByTitle(String title) {
    boolean found = false;
    for (Media media : itemsOrdered) {
        if (media.getTitle().equalsIgnoreCase(title)) {
            itemsOrdered.remove(media);
            System.out.println("Removed media with title: " + title);
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("No media found with title \"" + title + "\" to remove.");
    }
}
   // Phương thức phát media theo tiêu đề
public void playMedia(String title) {
    for (Media media : itemsOrdered) {
        if (media.getTitle().equalsIgnoreCase(title)) {
            if (media instanceof Playable) {
                ((Playable) media).play();  // Nếu media là Playable, gọi play
            } else {
                System.out.println("This media cannot be played.");
            }
            return;
        }
    }
    System.out.println("No media found with title \"" + title + "\" to play.");
}
    // Phương thức tạo đơn hàng và làm trống giỏ hàng
public void placeOrder() {
    System.out.println("Your order has been placed!");
    itemsOrdered.clear();  // Làm trống giỏ hàng
}
    
}