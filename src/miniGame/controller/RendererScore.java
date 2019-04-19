package miniGame.controller;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import miniGame.model.score.Score;
import miniGame.model.score.ScoreData;
import miniGame.model.shapes.Shape;
import miniGame.model.utils.Axis;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class RendererScore implements GLEventListener {
    List<Shape> shapes;
    private ScoreData scoreData= new ScoreData();
    private static DecimalFormat df = new DecimalFormat("0.00");
    public RendererScore(){
        if(shapes == null)
            this.shapes = new LinkedList<Shape>();
        else
            shapes = shapes;
    }


    public void add(Shape newShape) {
        this.shapes.add( newShape );
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {

        GL2 gl = glAutoDrawable.getGL().getGL2();
        List<Score> scores = scoreData.getTopFiveScores();



        // red background
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex2i(50,200-25);
        gl.glVertex2i(750, 200-25);
        gl.glVertex2i(750,600);
        gl.glVertex2i(50, 600);
        gl.glEnd();
        gl.glLoadIdentity();


        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(0.0f, 1.0f, 0.2f);
        gl.glVertex2i(300,100);
        gl.glVertex2i(500, 100);
        gl.glVertex2i(500,50);
        gl.glVertex2i(300, 50);
        gl.glEnd();
        gl.glLoadIdentity();

        TextRenderer textRenderer = new TextRenderer(new Font("Verdana", Font.BOLD, 30));
        textRenderer.beginRendering(800, 800);
        textRenderer.setSmoothing(true);

        Axis pt = new Axis(350, 750-25, 0);
        textRenderer.draw("SCORES", (int) (pt.getX()), (int) (pt.getY()));

        pt.setY(600);
        pt.setX(250);
        textRenderer.draw("1."+ scores.get(0).getGamer()+":"+df.format(scores.get(0).getScore()), (int) (pt.getX()), (int) (pt.getY()));
        pt.setY(500);
        pt.setX(250);
        textRenderer.draw("2."+ scores.get(1).getGamer()+":"+df.format(scores.get(1).getScore()), (int) (pt.getX()), (int) (pt.getY()));
        pt.setY(400);
        pt.setX(250);
        textRenderer.draw("3."+ scores.get(2).getGamer()+":"+df.format(scores.get(2).getScore()), (int) (pt.getX()), (int) (pt.getY()));
        pt.setY(300);
        pt.setX(250);
        textRenderer.draw("4."+ scores.get(3).getGamer()+":"+df.format(scores.get(3).getScore()), (int) (pt.getX()), (int) (pt.getY()));
        pt.setY(200);
        pt.setX(250);
        textRenderer.draw("5."+ scores.get(4).getGamer()+":"+df.format(scores.get(4).getScore()), (int) (pt.getX()), (int) (pt.getY()));

        pt.setY(75);
        pt.setX(350);
        textRenderer.draw("Voltar", (int) (pt.getX()), (int) (pt.getY()));
        textRenderer.endRendering();

        gl.glLoadIdentity();



    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable,  int x, int y, int width, int height)  {

        GL2 gl = glAutoDrawable.getGL().getGL2();
        GLU glu = new GLU();

        // get the OpenGL 2 graphics object
        if(height <= 0) height = 1;

        //preventing devided by 0 exception height = 1;
        final float h = (float) width / (float) height;

        // display area to cover the entire window
        gl.glViewport(0, 0, width, height);

        //transforming projection matrix
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0,width,0,height);

        //transforming model view gl.glLoadIdentity();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}
