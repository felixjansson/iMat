import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ItemAddedMessagePanelController extends AnchorPane {

    @FXML private Label nbrOfAddedItemLabel;

    @FXML private Label productAddedLabel;

    @FXML private Label titleLabel;

    public ItemAddedMessagePanelController(String title, String name, String amount) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ItemAddedMessagePanel.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ItemAddedMessagePanel");
        }

        titleLabel.setText(title);
        nbrOfAddedItemLabel.setText(amount);
        productAddedLabel.setText(name);
    }
}
