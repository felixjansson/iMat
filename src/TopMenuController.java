import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @FXML private ScrollPane productScrollPane;

    @FXML private GridPane productGridPane;

    private List<Integer[]> productID = new ArrayList<>();
    private String[] categoryName = {"Kött", "Fisk", "Mejeriprodukter", "Potatis & Ris",
            "Pasta", "Bröd","Citrusfrukter", "Exotiska Frukter", "Meloner","Stenfrukter",
            "Grönsaker", "Kål", "Rotfrukter", "Baljväxter", "Bär", "Örtkryddor", "Sötsaker",
            "Torrvaror", "Nötter & Frön", "Dryck"};

    @Override
    public void initialize(URL url, ResourceBundle bundle){
        populateProductID();
        initializeCategoryView();
        backButtonImage.setImage(new Image("img/backbutton.png"));

        categoryViewToFront();
    }

    private void populateProductID(){

        Integer[] kfm = {11,8,12};
        Integer[] kol = {17,16,2};
        Integer[] fr = {4,7,13,19};
        Integer[] green = {9,10,18};
        Integer[] green2 = {1,3,21};
        Integer[] ovrigt = {20,14,15,5};
        productID.add(kfm);
        productID.add(kol);
        productID.add(fr);
        productID.add(green);
        productID.add(green2);
        productID.add(ovrigt);

    }

    private void initializeCategoryView(){
        ProductCategory[] enumForCategories = ProductCategory.values();
        int count = 0;
        for(int i = 0; i < productID.size(); i++){
            Integer[] intTemp = productID.get(i);

            for (int j = 0; j <intTemp.length; j++){
                //New categoryview to add
                CategoryController categoryPane = new CategoryController(enumForCategories[intTemp[j] - 1],
                        categoryName[count++],DataHandler.getCategoryImage(enumForCategories[intTemp[j] - 1]), this);

                if (i == 4) {
                    categoryGridPane.add(categoryPane,j, 8);
                } else {

                    categoryGridPane.add(categoryPane,j,2*i + 1);
                }

            }
        }

    }

    @FXML
    protected void homeButtonActionPerformed(ActionEvent event) {
        System.out.println("hej");
    }

    @FXML
    protected void profileButtonActionPerformed(ActionEvent event)throws IOException {
        ProfileViewController profile = new ProfileViewController();

        System.out.println("Profilknapp fungerar");

    }

    public void productViewToFront() {
        productScrollPane.toFront();
    }

    public void categoryViewToFront() {
        categoryScrollPane.toFront();
    }

    public void addProductToGrid(Product product, int column, int row) {
        ProductViewController productView = new ProductViewController(product, product.getName(),
                DataHandler.getProductImage(product), 1, product.getUnitSuffix());
        productGridPane.add(productView, column, row);
    }
}
