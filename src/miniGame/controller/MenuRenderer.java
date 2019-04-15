package miniGame.controller;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import miniGame.model.utils.Axis;
import miniGame.model.shapes.Shape;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class MenuRenderer implements GLEventListener {


    List<Shape> shapes;

    public MenuRenderer(){
        if(shapes == null)
            this.shapes = new LinkedList<Shape>();
        else
            shapes = shapes;
    }


    public void add(Shape newShape) {
        this.shapes.add( newShape );
    }

    public boolean[] rotate  = new boolean[4];
    private float frames=0.0f;
    public boolean[] scale = new boolean[3];


    @Override
    public void init(GLAutoDrawable drawable) {

        scale[0]=false;
        scale[1]=false;
        scale[2]=false;
        rotate[0]=false;
        rotate[1]=false;
        rotate[2]=false;
        rotate[3]=false;
        GL2 gl = drawable.getGL().getGL2();
        System.err.println("INIT GL IS: " + gl.getClass().getName());


        gl.setSwapInterval(1);


        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL2.GL_SMOOTH);
    }


    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        if(rotate[0]){
            gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(1.0f,0.0f,0.0f);
            gl.glVertex2d(100+rotateX(frames,-50,-50),600+rotateY(frames,-50,-50));
            gl.glVertex2d(100+rotateX(frames,50,-50),600+rotateY(frames,50,-50));
            gl.glVertex2d(100+rotateX(frames,0,50),600+rotateY(frames,0,50));
            gl.glEnd();
        }else{
            //draw Triangulo
            gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(1.0f,0.0f,0.0f);
            gl.glVertex2i(100-50, 600-50);
            gl.glVertex2i(100+50,600-50);
            gl.glVertex2i(100+0,600+50);
            gl.glEnd();

        }


        gl.glLoadIdentity();

        // Draw A Quad
        if(rotate[1]){
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
            gl.glVertex2d(700.0f+rotateX(frames,-50,-50),100+rotateY(frames,-50,-50));
            gl.glVertex2d(700+rotateX(frames,50,-50), 100+rotateY(frames,50,-50));
            gl.glVertex2d(700+rotateX(frames,50,50), 100+rotateY(frames,50,50));
            gl.glVertex2d(700+rotateX(frames,-50,50),100+rotateY(frames,-50,50));
            // Done Drawing The Quad
            gl.glEnd();
        }else{
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
            gl.glVertex2i(700-50,100-50);
            gl.glVertex2i(700+50, 100-50);
            gl.glVertex2i(700+50, 100+50);
            gl.glVertex2i(700-50,100+50);
            // Done Drawing The Quad
            gl.glEnd();
        }
        gl.glLoadIdentity();

        if(rotate[2]){
            gl.glBegin(GL2.GL_POLYGON);
            gl.glColor3f(1.0f,0.0f,1.0f);
            for(int i=0;i<360;++i){
                double angulo= (2*Math.PI*i/360);
                gl.glVertex2d(700.0f+rotateX(frames,50.0f*Math.cos(angulo),50*Math.sin(angulo)),600.0f+rotateY(frames,50.0f*Math.cos(angulo),50.0f*Math.sin(angulo)));
            }
            gl.glEnd();
        }else{
            gl.glBegin(GL2.GL_POLYGON);
            gl.glColor3f(0.0f,0.0f,1.0f);
            for(int i=0;i<360;++i){
                double angulo= (2*Math.PI*i/360);
                gl.glVertex2d(700+ 50*Math.cos(angulo),600+50*Math.sin(angulo));
            }
            gl.glEnd();

            gl.glLoadIdentity();
        }
        //poligono


        if(rotate[3]){
            gl.glBegin(GL2.GL_POLYGON);
            gl.glColor3f(0.0f,1.0f,1.0f);
            for(int i=0;i<6;++i){
                double angulo= (2*Math.PI*i/6);
                gl.glVertex2d(100.0f+rotateX(frames,50.0f*Math.cos(angulo),50*Math.sin(angulo)),100.0f+rotateY(frames,50.0f*Math.cos(angulo),50.0f*Math.sin(angulo)));
            }//rotateX(frames,50*Math.cos(angulo),50*Math.sin(angulo))
            gl.glEnd();
        }else{
            gl.glBegin(GL2.GL_POLYGON);
            gl.glColor3f(0.0f,1.0f,1.0f);
            for(int i=0;i<6;++i){
                double angulo= (2*Math.PI*i/6);
                gl.glVertex2d(100+ 50*Math.cos(angulo),100+50*Math.sin(angulo));
            }
            gl.glEnd();
        }

        gl.glLoadIdentity();


        if(scale[0]){
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.7f, 0.9f, 0.7f);
            gl.glVertex2f(400-(200*1.25f),450-(50*1.25f));
            gl.glVertex2f(400+(200*1.25f), 450-(50*1.25f));
            gl.glVertex2f(400+(200*1.25f), 450+(50*1.25f));
            gl.glVertex2f(400-(200*1.25f),450+(50*1.25f));
            gl.glEnd();
        }else{
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.7f, 0.9f, 0.7f);
            gl.glVertex2i(400-200,450-50);
            gl.glVertex2i(400+200, 450-50);
            gl.glVertex2i(400+200, 450+50);
            gl.glVertex2i(400-200,450+50);
            gl.glEnd();
        }
        gl.glLoadIdentity();

        if(scale[1]){
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.7f, 0.9f, 0.7f);
            gl.glVertex2f(400-(200*1.25f),300-(50*1.25f));
            gl.glVertex2f(400+(200*1.25f), 300-(50*1.25f));
            gl.glVertex2f(400+(200*1.25f), 300+(50*1.25f));
            gl.glVertex2f(400-(200*1.25f),300+(50*1.25f));
            gl.glEnd();
        }else{
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.7f, 0.9f, 0.7f);
            gl.glVertex2i(400-200,300-50);
            gl.glVertex2i(400+200, 300-50);
            gl.glVertex2i(400+200, 300+50);
            gl.glVertex2i(400-200,300+50);
            gl.glEnd();
        }
        gl.glLoadIdentity();


       /* if(scale[2]){
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glVertex2f(400-(200*1.25f),150-(50*1.25f));
            gl.glVertex2f(400+(200*1.25f), 150-(50*1.25f));
            gl.glVertex2f(400+(200*1.25f), 150+(50*1.25f));
            gl.glVertex2f(400-(200*1.25f),150+(50*1.25f));
            gl.glEnd();
        }else{
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(1.0f, 0.3f, 0.3f);
            gl.glVertex2i(400-200,150-50);
            gl.glVertex2i(400+200, 150-50);
            gl.glVertex2i(400+200, 150+50);
            gl.glVertex2i(400-200,150+50);
            gl.glEnd();
        }*/




        frames+=2.0f/360.0f;
        if(frames>=360.0f){
            frames=0.0f;
        }

        this.drawText(gl);
        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    private void drawText(GL2 gl) {


        // TITULO E NOME DOS BOTOES

        TextRenderer textRenderer = new TextRenderer(new Font("Verdana", Font.BOLD, 50));
        textRenderer.beginRendering(800, 800);
        textRenderer.setSmoothing(true);

        Axis pt = new Axis(300-25, 700, 0);
        textRenderer.draw("ClickFall", (int) (pt.getX()), (int) (pt.getY()));

        pt.setY(500-50);
        pt.setX(300-50);
        textRenderer.draw("New Game", (int) (pt.getX()), (int) (pt.getY()));

        pt.setY(300);
        pt.setX(325);
        textRenderer.draw("Score", (int) (pt.getX()), (int) (pt.getY()));

       /* pt.setY(200-50);
        pt.setX(325);
        textRenderer.draw("Quit", (int) (pt.getX()), (int) (pt.getY()));
        */
        textRenderer.endRendering();

        gl.glLoadIdentity();

        gl.glFlush();
    }

    public void display1(GLAutoDrawable glAutoDrawable) {

        GL2 gl = glAutoDrawable.getGL().getGL2();

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



        // TITULO E NOME DOS BOTOES

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


    public double rotateX(float frames, double x, double y){
        return x*Math.cos(frames)-y*Math.sin(frames);
    }

    public double rotateY(float frames, double x , double y){
        return x*Math.sin(frames)+y*Math.cos(frames);
    }


    public void setRotate(int i){
        rotate[i]=true;
    }

    public void disableRotate(int i){
        rotate[i]=false;
    }

    public void focusMenu(int i){
        scale[i]=true;
    }

    public void notFocus(int i){
        scale[i]=false;
    }



}
