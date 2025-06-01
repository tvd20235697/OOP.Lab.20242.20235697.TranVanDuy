package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
        this.category = "Unknown"; // Default value for category
        this.cost = 0.0f; // Default value for cost
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Phương thức trừu tượng để hiển thị thông tin
    public abstract void displayInfo();

    // Phương thức để so sánh tiêu đề
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    // Phương thức để so sánh ID
    public boolean isMatch(int id) {
        return this.id == id;
    }

    @Override
    public boolean equals(Object o) {
        // Kiểm tra nếu đối tượng o là một đối tượng Media
        if (this == o) return true; // Nếu cùng một đối tượng
        if (o == null || getClass() != o.getClass()) return false; // Nếu o là null hoặc không phải là Media
        Media media = (Media) o; // Ép kiểu o thành đối tượng Media
        return title.equals(media.title); // So sánh tiêu đề
    }

    @Override
    public int hashCode() {
        return title.hashCode(); // HashCode dựa trên tiêu đề
    }
    @Override
    public String toString() {
        return "Media ID: " + id + "\nTitle: " + title + "\nCategory: " + category + "\nCost: " + cost + "$";
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}