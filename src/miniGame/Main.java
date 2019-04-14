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
import miniGame.model.old.Quadrilater;
import miniGame.model.old.QuadrilaterPainter;
import miniGame.model.shapes.Shape;
import miniGame.model.shapes.Square;

import javax.swing.*;
import java.awt.*;


public class Main extends Application {

    Renderer renderer = new Renderer();

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage ) throws Exception{

        // all configuration
        Dimension sceneDimension = new Dimension(800, 800);
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        GLCanvas menuCanvas = new GLCanvas(capabilities);
        GLCanvas gameCanvas = new GLCanvas(capabilities);
        menuCanvas.setSize( sceneDimension.getWidth(), sceneDimension.getHeight() );
        gameCanvas.setSize( sceneDimension.getWidth(), sceneDimension.getHeight() );

        JFrame menuFrame = new JFrame("Mini Game - Menu");
        JFrame gameFrame = new JFrame("Mini Game - ClickFall");

        menuFrame.getContentPane().add(menuCanvas);
        gameFrame.getContentPane().add(gameCanvas);

        menuFrame.setSize(menuFrame.getContentPane().getPreferredSize());
        gameFrame.setSize(menuFrame.getContentPane().getPreferredSize());

        menuFrame.setVisible(true);
        gameFrame.setVisible(false);

        menuCanvas.setFocusable(true);
        gameCanvas.setFocusable(false);

        menuFrame.setLocation(new Point(10,10));
        gameFrame.setLocation(new Point(20,20));

        Quadrilater square = new QuadrilaterPainter().rectangle(0.2, 0.1);
        square.setColor( new ColorPainter(1,0,0) );
        square.setAxis( new Axis(0,0,0) );



        Shape quadrado = new Square();
        quadrado.setColor( new ColorPainter(1,0,0) );
        quadrado.setAxis( new Axis(0,0,0) );


        this.renderer.add( square );
        this.renderer.add( quadrado );
        final FPSAnimator animator = new FPSAnimator(menuCanvas, 400,true);
        animator.start();
        menuCanvas.addGLEventListener( renderer );

/*

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
        btnPlay.setAxis(new Axis(0,0.0,0.0));
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

        menuCanvas.addGLEventListener( renderer );
*/

    }

}
