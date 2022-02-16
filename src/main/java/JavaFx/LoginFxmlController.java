package JavaFx;

import Registration.Entry;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginFxmlController {
    @FXML
    public TextField nameid;
    @FXML
    public TextField surnameid;
    @FXML
    public TextField emailid;

    @FXML
    public void onClosePressed(){
        Platform.exit();
    }
    @FXML
    public void onLoginPressed(){

    }
    @FXML
    public void onEmailPressed(){
        onLoginPressed();
    }

}
