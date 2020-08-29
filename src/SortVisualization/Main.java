package SortVisualization;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        int sceneEndX = 1000;
        int sceneEndY = 400;
        int linesQuantity = 5;

        Group root = new Group();
        Scene scene = new Scene(root,  LineManager.SCENE_X, LineManager.SCENE_Y + 50);
        scene.setFill(Color.BLACK);
        FileInputStream input = new FileInputStream("src/icon.png");
        Image icon = new Image(input);
        ImageView imageView = new ImageView(icon);
        primaryStage.setTitle("Sort Visualization");

        SortDrawer sortDrawer = new SortDrawer();
        sortDrawer.Drawer(root);

        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

