package miniGame.controller;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import miniGame.model.shapes.Shape;
import miniGame.model.utils.Axis;
import miniGame.model.utils.Dimension;
import miniGame.model.utils.Position;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameRenderer implements GLEventListener {


    List<Shape> shapes;
    private int score;

    public GameRenderer(){
        this.score = 0;
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

        TextRenderer textRenderer = new TextRenderer(new Font("Verdana", Font.BOLD, 30));
        textRenderer.beginRendering(800, 800);
        textRenderer.setSmoothing(true);

        Axis pt = new Axis(10, 700, 0);
        textRenderer.draw("Score: ", (int) (pt.getX()), (int) (pt.getY()));
        textRenderer.draw(""+score, (int) (pt.getX()+10), (int) (pt.getY()-30));
        textRenderer.endRendering();


        GL2 gl = glAutoDrawable.getGL().getGL2();

        // field to display the current one
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
        gl.glVertex2i(700-80,600-50);
        gl.glVertex2i(700+50, 600-50);
        gl.glVertex2i(700+50, 600+80);
        gl.glVertex2i(700-80,600+80);
        gl.glLoadIdentity();
        gl.glEnd();

        // field to display options
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
        gl.glVertex2i(50,250-50);
        gl.glVertex2i(750, 250-50);
        gl.glVertex2i(750, 450-50);
        gl.glVertex2i(50,450-50);
        gl.glEnd();
        gl.glLoadIdentity();
        gl.glFlush();


    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable,  int x, int y, int width, int height) {

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