package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;

    // Constructor cho Book
    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(id, title, category, cost);  // Gọi constructor của Media
        this.authors = authors;
    }

    // Getter và Setter cho authors
    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    // Phương thức hiển thị thông tin sách
    @Override
    public void displayInfo() {
        System.out.println("Book ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Cost: " + getCost() + "$");
        System.out.print("Authors: ");
        for (String author : authors) {
            System.out.print(author + " ");
        }
        System.out.println();
    }
    @Override
    public String toString() {
        return super.toString() + "\nAuthors: " + String.join(", ", authors);
    }
}