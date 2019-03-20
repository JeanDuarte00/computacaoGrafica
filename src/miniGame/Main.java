package miniGame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javafx.application.Application;
import javafx.stage.Stage;
import miniGame.model.configuration.Dimension;
import miniGame.model.configuration.Position;
import miniGame.model.shapes.Polygon;
import miniGame.model.shapes.Quadrilater;
import miniGame.model.shapes.Rhombus;
import miniGame.model.shapes.Triangle;
import miniGame.painter.QuadrilaterPainter;

import javax.swing.*;
import java.awt.*;


public class Main extends Application {

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage ) throws Exception{

        // all configuration and setting it's propreties
        Dimension sceneDimension = new Dimension(600, 600);
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);


        GLCanvas glcanvas = new GLCanvas(capabilities);
        glcanvas.setSize(sceneDimension.getWidth(), sceneDimension.getHeight());
        JFrame frame = new JFrame("Mini Game - Catch de Shape");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        glcanvas.setFocusable(true);
        glcanvas.setBackground(Color.CYAN);


        Triangle triangle = new Triangle(new Position(0.3,0.2), new Position(0.3, 0.23), new Position(0.6,0.1));
        Rhombus rhombus = new Rhombus();


        Quadrilater square = new QuadrilaterPainter().square(0.1);

        Quadrilater rect = new QuadrilaterPainter().rectangle(0.8, 0.1);


        Polygon polygon = new Polygon(
                new Position(0.0, 0.7), new Position(0.8, 0.2), new Position(0.8, 0.2),
                new Position(0.0, 0.7), new Position(0.8, 0.2), new Position(0.8, 0.2),
                new Position(0.8, 0.2), new Position(0.0, 0.7)
        );


        // draw to the canvas
        glcanvas.addGLEventListener(triangle);


    }

}
