package JavaFx;

import UserType.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TestFxmlController implements Initializable {
    @FXML
    Label nameLabel;
    @FXML
    Label surnameLabel;
    @FXML
    Label emailLabel;
    public static User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(user.getName());
        surnameLabel.setText(user.getLastName());
        emailLabel.setText(user.getEmail());

    }


}

