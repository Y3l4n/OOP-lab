package AIMS.screen;

import java.awt.Button;

import AIMS.Cart.Cart;
import AIMS.media.Media;
import AIMS.playable.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    @FXML
    private TableView<Media> tableMedia;
    
    @FXML
    private TableColumn<Media, String> columnMediaTitle;

    @FXML
    private TableColumn<Media, String> columnMediaCategory;

    @FXML
    private TableColumn<Media, String> columnMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private void initialize(){
        columnMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        columnMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        columnMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("cost"));

    }



    @FXML
    private ListView<String> cartListView;

    @FXML
    private TextField totalCostField;

    private Cart cart;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    public void start() {
        updateCartView();
    }

    private void updateCartView() {
        cartListView.getItems().clear();
        cart.getItems().forEach(item -> cartListView.getItems().add(item.toString()));
        totalCostField.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnRemovePressed(ActionEvent evt){
        Media media = tableMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
}