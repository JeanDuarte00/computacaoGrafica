package miniGame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import javafx.application.Application;
import javafx.stage.Stage;
import miniGame.controller.Renderer;
import miniGame.model.configuration.Axis;
import miniGame.model.configuration.ColorPainter;
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

    Renderer renderer = new Renderer();

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
        frame.setLocation(new Point(10,10));

        Triangle triangle = new Triangle(new Position(0.3,0.2), new Position(0.3, 0.23), new Position(0.6,0.1));
        Rhombus rhombus = new Rhombus();
        Quadrilater square = new QuadrilaterPainter().square(0.1);
        Quadrilater rect = new QuadrilaterPainter().rectangle(0.8, 0.1);
        Polygon polygon = new Polygon(
                new Position(0.0, 0.7), new Position(0.8, 0.2), new Position(0.8, 0.2),
                new Position(0.0, 0.7), new Position(0.8, 0.2), new Position(0.8, 0.2),
                new Position(0.8, 0.2), new Position(0.0, 0.7)
        );


        Quadrilater btnPlay = new QuadrilaterPainter( ).rectangle(0.40,0.15);

        Quadrilater btnClose = new QuadrilaterPainter( ).rectangle(0.40,0.15);


        square.setColor(new ColorPainter(1,0,0));
        square.setAxis(new Axis(0,0,0));
        // put it to be executed
        btnPlay.setAxis(new Axis(0,0.3,0.0));
        btnPlay.setColor(new ColorPainter(1,1,0));
        //glcanvas.addGLEventListener();

        btnClose.setAxis(new Axis(0,0.3,0));
        btnClose.setColor(new ColorPainter(0,0,1));
        //glcanvas.addGLEventListener(triangle);

        // draw to the canvas
        //glcanvas.display();


        //this.renderer.add(btnClose);
        this.renderer.add(btnPlay);
        this.renderer.add(square);

        glcanvas.addGLEventListener( renderer );

        final FPSAnimator animator = new FPSAnimator(glcanvas, 400,true);
        animator.start();
    }

}
