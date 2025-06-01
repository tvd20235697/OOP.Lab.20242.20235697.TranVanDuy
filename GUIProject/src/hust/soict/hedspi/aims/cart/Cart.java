package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Scanner;

import javax.naming.LimitExceededException;

public class Cart {
    // Maximum number of items allowed in the cart
    private static final int MAX_NUMBERS_ORDERED = 20; // You can adjust this value as needed

    // Danh sách các media trong giỏ hàng, sử dụng ObservableList để hỗ trợ JavaFX
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // ✅ Getter để JavaFX sử dụng (ví dụ cho TableView)
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // Thêm media vào giỏ hàng
    public void addMedia(Media media) throws LimitExceededException {
        // Check if adding a new item exceeds the maximum limit
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit!");
        }

        // Proceed with adding the media if the limit is not exceeded
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added.");
        } else {
            System.out.println(media.getTitle() + " is already in the cart.");
        }
    }

    // Xóa media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    // Xóa media theo tiêu đề
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

    // Hiển thị nội dung giỏ hàng
    public void displayCart() {
        System.out.println("***********************CART***********************");
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            media.displayInfo();
            totalCost += media.getCost();
        }
        System.out.printf("Total cost: %.2f$\n", totalCost);
        System.out.println("The number of items in the cart is: " + itemsOrdered.size());
        System.out.println("**************************************************");
    }

    // Tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Tìm kiếm media theo tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
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

    // Tìm kiếm media theo ID
    public void searchById(int id) {
        boolean found = false;
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

    // Sắp xếp theo tiêu đề rồi chi phí
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by Title and Cost:");
        displayCart();
    }

    // Sắp xếp theo chi phí rồi tiêu đề
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by Cost and Title:");
        displayCart();
    }

    // Lọc media trong giỏ hàng theo ID hoặc tiêu đề
    public void filterMedia(String filterBy) {
        Scanner scanner = new Scanner(System.in);
        if ("id".equalsIgnoreCase(filterBy)) {
            System.out.print("Enter ID to filter: ");
            int id = scanner.nextInt();
            searchById(id);
        } else if ("title".equalsIgnoreCase(filterBy)) {
            System.out.print("Enter title to filter: ");
            String title = scanner.nextLine();
            searchByTitle(title);
        } else {
            System.out.println("Invalid filter option. Please try again.");
        }
    }

    // Sắp xếp media trong giỏ hàng theo yêu cầu
    public void sortMedia(String sortBy) {
        if ("title".equalsIgnoreCase(sortBy)) {
            sortByTitleCost();
        } else if ("cost".equalsIgnoreCase(sortBy)) {
            sortByCostTitle();
        } else {
            System.out.println("Invalid sort option. Please try again.");
        }
    }

    // Phát media theo tiêu đề nếu nó có thể phát
    public void playMedia(String title) {
        for (Media media : itemsOrdered) {
        	if (media instanceof Playable) {
                try {
                    ((Playable) media).play();
                    System.out.println("Playing media: " + title);
                } catch (PlayerException e) {
                    System.err.println("Error playing media: " + e.getMessage());
                }
            } else {
                System.out.println("This media cannot be played.");
            }
        }
        System.out.println("No media found with title \"" + title + "\" to play.");
    }

    // Đặt đơn hàng và làm trống giỏ hàng
    public void placeOrder() {
        System.out.println("Your order has been placed!");
        itemsOrdered.clear();
    }
}