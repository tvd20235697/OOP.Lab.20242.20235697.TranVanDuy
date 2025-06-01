package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;

    // Constructor cho DigitalVideoDisc
    public DigitalVideoDisc( String title, String category,  String director, int length,float cost) {
        super(nbDigitalVideoDiscs+1, title, category, cost, director, length);  // Gọi constructor của Disc
        nbDigitalVideoDiscs++;
        this.director = director;
        this.length = length;
    }


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void displayInfo() {
        System.out.println("DVD ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Director: " + director);
        System.out.println("Length: " + length + " minutes");
        System.out.println("Cost: " + getCost() + "$");
    }

    public static int getnbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

     // Cài đặt phương thức play() cho DigitalVideoDisc
     @Override
     public void play() throws PlayerException {
 		if (this.getLength() > 0) {
 			System.out.println("Playing DVD: " + this.getTitle());
 			System.out.println("DVD length: " + this.getLength());
 		} else {
 			throw new PlayerException("ERROR: DVD length is non-positive!");
 		}
 	}
     @Override
    public String toString() {
        return super.toString() + "\nDirector: " + director + "\nLength: " + length + " minutes";
    }
}