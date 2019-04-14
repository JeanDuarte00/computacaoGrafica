package miniGame;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import javafx.application.Application;
import javafx.stage.Stage;
import miniGame.controller.RendererScore;
import miniGame.model.configuration.Axis;
import miniGame.model.configuration.ColorPainter;
import miniGame.model.configuration.Dimension;
import miniGame.model.old.Quadrilater;
import miniGame.model.old.QuadrilaterPainter;
import miniGame.model.score.Score;
import miniGame.model.score.ScoreData;
import miniGame.model.shapes.Shape;
import miniGame.model.shapes.Square;

import javax.swing.*;
import java.awt.*;

public class MainScore extends Application {


    RendererScore renderer = new RendererScore();


    public static void main(String[] args) {
        ScoreData sd = new ScoreData();
        sd.saveScore(new Score("cpu01",10));
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
        JFrame scoreFrame = new JFrame("Mini Game - Scores");

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

    }
}

