package miniGame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import miniGame.model.*;

import javax.swing.*;


public class Main extends Application {

    private Scene scene;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage ) throws Exception{

        Dimension sceneDimension = new Dimension(600, 600);
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas glcanvas = new GLCanvas(capabilities);
        glcanvas.setSize(sceneDimension.getWidth(), sceneDimension.getHeight());
        JFrame frame = new JFrame("Mini Game - Catch de Shape");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);




        Triangle triangle = new Triangle(new Position(0.3,0.2), new Position(0.3, 0.23), new Position(0.6,0.1));
        Rhombus rhombus = new Rhombus();
        Square square = new Square( new Position(0.5, 0.5), new Position(0.5, 0.5), new Position(0.5, 0.5), new Position(0.5, 0.5), new Position(0.0, 0.0) );
        Polygon polygon = new Polygon(
                new Position(0.0, 0.7), new Position(0.8, 0.2), new Position(0.8, 0.2),
                new Position(0.0, 0.7), new Position(0.8, 0.2), new Position(0.8, 0.2),
                new Position(0.8, 0.2), new Position(0.0, 0.7)
        );




        glcanvas.addGLEventListener(square);


    }

}
