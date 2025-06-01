package hust.soict.hedspi.aims.media;


import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist; // Nghệ sĩ
    private ArrayList<Track> tracks; // Danh sách các bài hát (track)
    // Constructor cho CompactDisc
    public CompactDisc(int id, String title, String category, float cost, String director, String artist, int length) {
        super(id, title, category, cost, director, length);  // Gọi constructor của Disc
        this.artist = artist;
        this.tracks = new ArrayList<>();  // Khởi tạo danh sách các track
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Getter cho tracks
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    // Phương thức thêm track vào danh sách tracks
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {  // Kiểm tra xem track đã tồn tại trong CD chưa
            tracks.add(track);
            System.out.println(track.getTitle() + " has been added.");
        } else {
            System.out.println(track.getTitle() + " is already in the CD.");
        }
    }
    

    // Phương thức xóa track khỏi danh sách tracks
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {  // Kiểm tra nếu track có trong danh sách
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " has been removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " is not in the list.");
        }
    }

    // Phương thức tính tổng độ dài của CD (tổng độ dài của tất cả các track)
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Phương thức hiển thị thông tin CompactDisc
    @Override
    public void displayInfo() {
        System.out.println("CD ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Artist: " + artist);
        System.out.println("Director: " + getDirector());
        System.out.println("Length: " + getLength() + " minutes");
        System.out.println("Cost: " + getCost() + "$");
        System.out.println("Tracks: ");
        for (Track track : tracks) {
            track.displayTrackInfo();  // Hiển thị thông tin cho từng track
        }
    }

     // Cài đặt phương thức play() cho CompactDisc
     @Override
     public void play() throws PlayerException {
 		if (this.getLength() > 0) {
 			System.out.println("Playing CD: " + this.getTitle());
 			System.out.println("CD length: " + this.getLength());
 			
 			java.util.Iterator iter = tracks.iterator();
 			Track nextTrack;
 			while (iter.hasNext()) {
 				nextTrack = (Track) iter.next();
 				nextTrack.play();
 			}
 		} else {
 			throw new PlayerException("ERROR: CD length is non-positive!");
 		}
 	}

     @Override
     public String toString() {
         StringBuilder trackInfo = new StringBuilder();
         for (Track track : tracks) {
             trackInfo.append("\n- ").append(track.getTitle()).append(" (").append(track.getLength()).append(" minutes)");
         }
         return super.toString() + "\nArtist: " + artist + "\nTracks: " + trackInfo.toString();
     }

}