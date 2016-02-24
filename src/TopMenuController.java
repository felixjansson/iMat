import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.net.URL;
import java.util.ResourceBundle;


public class TopMenuController extends AnchorPane implements Initializable{
    @FXML private TextField searchTextField;

    @FXML private Button backButton;

    @FXML private Button homeButton;

    @FXML private Button profileButton;

    @FXML private Button purchaseHistoryButton;

    @FXML private Button shoppingCartButton;

    @FXML private ImageView backButtonImage;

    @FXML private StackPane baseStackPane;

    @FXML private ScrollPane categoryScrollPane;

    @FXML private GridPane categoryGridPane;

    @Override
    public void initialize(URL url, ResourceBundle bundle){
//        System.out.println("a");
        backButtonImage.setImage(new Image("img/backbutton.png"));
        CategoryController categoryPane = new CategoryController();

        categoryPane.setCategoryName(DataHandler.getCategory(1));
        categoryPane.setCategoryImage(DataHandler.getCategoryImage(ProductCategory.BERRY));

        categoryGridPane.add(categoryPane, 0, 1);

        CategoryController categoryPane2 = new CategoryController();

        categoryPane2.setCategoryName(DataHandler.getCategory(1));
        categoryPane2.setCategoryImage(DataHandler.getCategoryImage(ProductCategory.BERRY));

        categoryGridPane.add(categoryPane2, 0, 3);

        CategoryController categoryPane3 = new CategoryController();

        categoryPane3.setCategoryName(DataHandler.getCategory(1));
        categoryPane3.setCategoryImage(DataHandler.getCategoryImage(ProductCategory.BERRY));

        categoryGridPane.add(categoryPane3, 0, 5);

        //testing columns
        CategoryController categoryPane4 = new CategoryController();

        categoryPane4.setCategoryName(DataHandler.getCategory(1));
        categoryPane4.setCategoryImage(DataHandler.getCategoryImage(ProductCategory.BERRY));

        categoryGridPane.add(categoryPane4, 1, 1);

        CategoryController categoryPane5 = new CategoryController();

        categoryPane5.setCategoryName(DataHandler.getCategory(1));
        categoryPane5.setCategoryImage(DataHandler.getCategoryImage(ProductCategory.BERRY));

        categoryGridPane.add(categoryPane5, 2, 1);

        CategoryController categoryPane6 = new CategoryController();

        categoryPane6.setCategoryName(DataHandler.getCategory(1));
        categoryPane6.setCategoryImage(DataHandler.getCategoryImage(ProductCategory.BERRY));

        categoryGridPane.add(categoryPane6, 3, 1);
    }

    @FXML
    protected void homeButtonActionPerformed(ActionEvent event) {
        System.out.println("hej");
    }

    @FXML
    protected void profileButtonActionPerformed(ActionEvent event){
        System.out.println("Profilknapp fungerar");
        ProfileViewController profileController = new ProfileViewController();
        profileController.toFront();
    }

}
