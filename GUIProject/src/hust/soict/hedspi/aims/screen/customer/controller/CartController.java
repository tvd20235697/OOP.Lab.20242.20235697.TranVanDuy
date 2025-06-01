package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {

    private Cart cart;
    private Store store;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaID;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnViewStore;
    @FXML
    private Label lblMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    public void initialize() {
        // Thiết lập dữ liệu cho các cột trong bảng
        colMediaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Gán danh sách sản phẩm từ cart
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        // Ẩn nút khi chưa chọn gì
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Cập nhật tổng chi phí ban đầu
        updateTotalCost();

        // Khi người dùng chọn một item trong bảng
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
                updateMediaInfo(newValue);
            }
        });

        // Thêm listener để cập nhật bộ lọc khi thay đổi RadioButton
        filterCategory.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            showFilteredMedia(tfFilter.getText());
        });

        // Thêm ChangeListener cho TextField
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        // Thêm listener để cập nhật tổng chi phí khi giỏ hàng thay đổi
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) change -> {
            updateTotalCost();
        });
    }

    private void showFilteredMedia(String filterText) {
        ObservableList<Media> filteredList = FXCollections.observableArrayList();

        // Nếu không có giá trị lọc, hiển thị toàn bộ danh sách
        if (filterText == null || filterText.isEmpty()) {
            filteredList.addAll(cart.getItemsOrdered());
        } else {
            for (Media media : cart.getItemsOrdered()) {
                // Lọc theo ID
                if (radioBtnFilterId.isSelected() && String.valueOf(media.getId()).contains(filterText)) {
                    filteredList.add(media);
                }
                // Lọc theo tiêu đề
                else if (radioBtnFilterTitle.isSelected() && media.getTitle().toLowerCase().contains(filterText.toLowerCase())) {
                    filteredList.add(media);
                }
            }
        }

        // Cập nhật TableView với danh sách đã lọc
        tblMedia.setItems(filteredList);
    }

    // Cập nhật trạng thái nút Play/Remove
    private void updateButtonBar(Media media) {
        boolean hasMedia = media != null;
        btnRemove.setVisible(hasMedia);
        btnPlay.setVisible(hasMedia && media instanceof Playable);
    }

    // Cập nhật thông tin tiêu đề media
    private void updateMediaInfo(Media media) {
        if (lblMediaTitle != null) {
            lblMediaTitle.setText(media != null ? media.getTitle() : "");
        }
    }

    // Cập nhật tổng chi phí
    private void updateTotalCost() {
        float total = 0;
        for (Media media : cart.getItemsOrdered()) {
            total += media.getCost();
        }
        costLabel.setText(String.format("%.2f $", total));
    }

    // Sự kiện nhấn nút Remove
    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cart.removeMedia(selected);
            tblMedia.refresh(); // Cập nhật lại bảng
            updateButtonBar(null);
            updateMediaInfo(null);
        }
    }

    // Sự kiện nhấn nút Play
    @FXML
    private void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Không có media được chọn");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn một media để phát!");
            alert.showAndWait();
            return;
        }
        
        if (!(media instanceof Playable)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Không thể phát");
            alert.setHeaderText(null);
            alert.setContentText("Media này không thể phát được!");
            alert.showAndWait();
            return;
        }

        try {
            ((Playable) media).play();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Play Media");
            alert.setHeaderText(null);
            alert.setContentText("Đang phát: " + media.getTitle());
            alert.showAndWait();
            
        } catch (PlayerException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Lỗi phát media");
            errorAlert.setHeaderText("Không thể phát media");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
            
            System.err.println("Lỗi khi phát media: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Lỗi không xác định");
            errorAlert.setHeaderText("Đã xảy ra lỗi");
            errorAlert.setContentText("Có lỗi xảy ra khi phát media: " + e.getMessage());
            errorAlert.showAndWait();
            
            System.err.println("Lỗi không xác định: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty! Cannot place order.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Order placed successfully! Total cost: " + costLabel.getText());
        alert.showAndWait();

        cart.getItemsOrdered().clear(); // Xóa giỏ hàng sau khi đặt hàng
        tblMedia.refresh();
        updateTotalCost();
    }
}