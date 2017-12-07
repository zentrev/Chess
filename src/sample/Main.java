package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Limbo.SecondaryController;

public class Main extends Application {
    public static Stage mainWindow;
    private static boolean prymary = false;
    static Scene primaryScene = null;
    static Scene secondaryScene = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainWindow = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
        primaryScene = new Scene(root, 1000, 670);
        Parent secondary = FXMLLoader.load(getClass().getResource("SecondaryScene.fxml"));
        secondaryScene = new Scene(secondary, 1000, 600);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        prymary = true;
    }
    public static void Switch(){
        System.out.println("Switching Scenes");
        if(prymary){
            mainWindow.setScene(secondaryScene);
            prymary = false;
        } else if(!prymary){
            mainWindow.setScene(primaryScene);
            prymary = true;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
