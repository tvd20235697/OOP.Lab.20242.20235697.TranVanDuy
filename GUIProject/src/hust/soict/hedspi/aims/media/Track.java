package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private String title; // Tiêu đề của bài hát
    private int length; // Độ dài của bài hát (tính bằng phút hoặc giây)

    // Constructor khởi tạo Track
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // Phương thức hiển thị thông tin track
    public void displayTrackInfo() {
        System.out.println("Track Title: " + title);
        System.out.println("Track Length: " + length + " minutes");
    }

     // Cài đặt phương thức play() cho Track
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
    public boolean equals(Object o) {
        if (this == o) return true; // Nếu cùng một đối tượng
        if (o == null || getClass() != o.getClass()) return false; // Nếu o là null hoặc không phải là Track
        Track track = (Track) o; // Ép kiểu o thành đối tượng Track
        return length == track.length && title.equals(track.title); // So sánh tiêu đề và độ dài
    }

    @Override
    public int hashCode() {
        return title.hashCode() * 31 + length; // HashCode dựa trên tiêu đề và độ dài
    }
}