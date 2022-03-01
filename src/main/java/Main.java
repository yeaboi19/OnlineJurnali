import Startup.Startup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
//TODO:finish loginTeacher.fxml
//DONE:weird visual bug where a duplicate screen opens after logging in and pressing close
//student is now in its beta form might add more features to it
//fixed minor issues
public class Main extends Application {
    public static void main(String[] args) {
        new Startup();
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Startup();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
/*
admin id  - 0000*
*/