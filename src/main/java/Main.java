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

//     overrides work now
//     made DAO classes to sort and make easy changes to the code
//TODO:while on login scene inputting wrong login credential will get errors
//TODO:finish loginTeacher.fxml

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