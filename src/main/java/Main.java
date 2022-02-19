import Registration.Entry;
import Startup.Startup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
//TODO:go back button REQUIRES OVERRIDE SCENE
//TODO:student register DONE
//TODO:override scene I REALLY HAVE NO IDEA
//TODO:login info DONE

public class Main extends Application {
    public static void main(String[] args) {
        new Startup(); //added a new column so delete grades table and relaunch. thx
        Entry e = new Entry();

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Startup();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
/*
admin id  - 0000*
*/