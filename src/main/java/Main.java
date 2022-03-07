import Startup.Startup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
//loginTeacher has a functioning table
//done now they automatically refresh
//TODO:finish other filter buttons
/*

cumcumcumcumcumcumcumcumc

*/
//TODO:ADD REMOVE AND ADD TO ADMIN WINDOW
public class Main extends Application {
    public static void main(String[] args) {
//        new Startup();
        launch(args);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        new Startup();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
/*
admin id  - 0000*
*/