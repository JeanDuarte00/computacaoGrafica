package miniGame.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

public class ScreenController {

    Image icon;
    String title;

    private HashMap<String, Parent> screenMap;
    private Scene scene;


    public ScreenController(String title, String path) {
        this.scene = scene;
        screenMap = new HashMap<>();
        this.title = title;
        this.icon = new Image("file:" + path);


    }

    public void addScreen(String name, Parent screen){
        screenMap.put(name, screen);
    }

    public void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name){
        scene.setRoot( screenMap.get(name) );
    }

    public Scene getScene(){
        return this.scene;
    }

    public Image getIcon(){
        return this.icon;
    }

    public String getTitle(){
        return this.title;
    }

    public void init(Stage stage){
        stage.getIcons().add( this.getIcon() );
        stage.setTitle( this.getTitle() );
        stage.setScene(scene);

    }

}