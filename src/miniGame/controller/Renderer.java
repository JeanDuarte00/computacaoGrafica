package miniGame.controller;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import miniGame.model.shapes.Shape;
import miniGame.model.utils.Axis;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Renderer implements GLEventListener {


    List<Shape> shapes;

    public Renderer(){
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
/*
        gl.glClearColor(0.0f,0.0f,0.0f,0.0f);
        gl.glClear (GL2.GL_COLOR_BUFFER_BIT |  GL2.GL_DEPTH_BUFFER_BIT );


        this.shapes.forEach( (shape) -> {
            shape.draw(gl);
            System.out.println(shape.getId());
        } );

        gl.glFlush();
        System.out.println("-----out----");*/
        //draw Triangulo




        // triangulo
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(1.0f,0.3f,0.2f);
        gl.glVertex2i(50, 650-25);
        gl.glVertex2i(150,650-25);
        gl.glVertex2i(100,750-25);
        gl.glEnd();



        gl.glLoadIdentity();

        // Draw A Quad
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
        gl.glVertex2i(650,50-25);
        gl.glVertex2i(750, 50-25);
        gl.glVertex2i(750, 150-25);
        gl.glVertex2i(650,150-25);
        // Done Drawing The Quad
        gl.glEnd();

        gl.glLoadIdentity();

        //circulo
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(0.0f,0.0f,1.0f);
        for(int i=0;i<360;++i){
            double angulo= (2*Math.PI*i/360);
            gl.glVertex2d(700+ 50*Math.cos(angulo),700-25+50*Math.sin(angulo));
        }
        gl.glEnd();

        gl.glLoadIdentity();

        //poligono
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(0.0f,1.0f,1.0f);
        for(int i=0;i<6;++i){
            double angulo= (2*Math.PI*i/6);
            gl.glVertex2d(100+ 50*Math.cos(angulo),100-25+50*Math.sin(angulo));
        }
        gl.glEnd();

        gl.glLoadIdentity();
        // Draw A btn new game
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 0.0f, 0.0f);    // Set the current drawing color to light blue

        gl.glVertex2i(200,200-25);
        gl.glVertex2i(600, 200-25);
        gl.glVertex2i(600,300-25);
        gl.glVertex2i(200, 300-25);


        // Done Drawing The Quad
        gl.glEnd();
        gl.glLoadIdentity();


        gl.glLoadIdentity();
        // Draw A btn new game
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(0.2f, 0.2f, 0.4f);    // Set the current drawing color to light blue

        gl.glVertex2i(200,350-25);
        gl.glVertex2i(600, 350-25);
        gl.glVertex2i(600,450-25);
        gl.glVertex2i(200, 450-25);
        // Done Drawing The Quad
        gl.glEnd();
        gl.glLoadIdentity();

        gl.glLoadIdentity();
        // Draw A btn new game
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(0.0f, 1.0f, 0.2f);    // Set the current drawing color to light blue

        gl.glVertex2i(200,500);
        gl.glVertex2i(600, 500);
        gl.glVertex2i(600,600);
        gl.glVertex2i(200, 600);


        // Done Drawing The Quad
        gl.glEnd();
        gl.glLoadIdentity();

        TextRenderer textRenderer = new TextRenderer(new Font("Verdana", Font.BOLD, 50));
        textRenderer.beginRendering(800, 800);
        textRenderer.setSmoothing(true);

        Axis pt = new Axis(300-25, 750-25, 0);
        textRenderer.draw("ClickFall", (int) (pt.getX()), (int) (pt.getY()));

        pt.setY(600-25);
        pt.setX(300-50);
        textRenderer.draw("New Game", (int) (pt.getX()), (int) (pt.getY()));

        pt.setY(400-25);
        pt.setX(325);
        textRenderer.draw("Score", (int) (pt.getX()), (int) (pt.getY()));
        pt.setY(250-25);
        pt.setX(325);
        textRenderer.draw("Quit", (int) (pt.getX()), (int) (pt.getY()));
        textRenderer.endRendering();

        gl.glLoadIdentity();



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
