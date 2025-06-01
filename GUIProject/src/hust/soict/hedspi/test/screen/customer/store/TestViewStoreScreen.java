package hust.soict.hedspi.test.screen.customer.store;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
      private static Store store;
      @Override
      public void start(Stage primaryStage) throws Exception {
          final String START_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(START_FXML_FILE_PATH));

          // Sửa ở đây
          Cart cart = new Cart();
          ViewStoreController viewStoreController = new ViewStoreController(store, cart);
          fxmlLoader.setController(viewStoreController);

          Parent root = fxmlLoader.load();
          primaryStage.setTitle("Store");
          primaryStage.setScene(new Scene(root));
          primaryStage.show();
      }

      public static void main(String[] args) throws LimitExceededException {
    	  store = new Store();

    	    CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", 15.5f, "John Director", "Famous Artist", 60);
    	    store.addMedia(cd);

    	    DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Action", "Wachowski Brothers", 136, 25.0f);
    	    store.addMedia(dvd);

    	    // Kiểm tra length
    	    System.out.println("CD length: " + cd.getLength());
    	    System.out.println("DVD length: " + dvd.getLength());

    	    // Thử phát media
    	    Cart cart = new Cart();
    	    cart.addMedia(dvd);
    	    cart.playMedia("The Matrix");
    	    CompactDisc cde = new CompactDisc(1, "Test CD", "Pop", 15.0f, "Director", "Artist", 60);
    	    System.out.println("Number of tracks: " + cde.getTracks().size());
    	    System.out.println("CD length: " + cde.getLength());
    	    cde.addTrack(new Track("Song 1", 30));
    	    cde.addTrack(new Track("Song 2", 20));
    	    System.out.println("Number of tracks: " + cde.getTracks().size());
    	    System.out.println("CD length: " + cde.getLength());
    	    store.addMedia(cde);
    	    ArrayList<String> authors = null;
			store.addBook(1, "Harry Potter and the Sorcerer's Stone", "Fantasy", 29.99f, authors);
    	    launch(args);
    	    
      }
}
