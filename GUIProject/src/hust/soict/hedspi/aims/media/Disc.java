package hust.soict.hedspi.aims.media;


public class Disc extends Media {
    private int length; // Độ dài của đĩa (số phút)
    private String director; // Đạo diễn của đĩa

    // Constructor cho Disc
    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);  // Gọi constructor của Media
        this.director = director;
        this.length = length;
    }

    // Getter cho length và director
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    // Setter cho length và director
    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Phương thức hiển thị thông tin Disc
    @Override
    public void displayInfo() {
        System.out.println("Disc ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Director: " + director);
        System.out.println("Length: " + length + " minutes");
        System.out.println("Cost: " + getCost() + "$");
    }
}