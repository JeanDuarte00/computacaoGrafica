package miniGame.controller;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import miniGame.model.enums.Colors;
import miniGame.model.shapes.Shape;
import miniGame.model.utils.Axis;


import java.awt.*;
import java.util.*;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class GameRenderer implements GLEventListener {


    List<Shape> shapes;
    private static int score = 10;
    private int score;
    private List<Colors> colorsList= Arrays.asList(Colors.VERMELHO,Colors.AMARELO,Colors.AZUL,Colors.VERDE);
    private Random rand = new Random();

    public void upScore (int up) {
        this.score  = this.score + up ;
    }

    public void downScore (int down) {
        this.score = this.score - down ;
    }


    public GameRenderer(){
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

        Axis pt = new Axis(85, 700, 0);
        textRenderer.draw("Score: ", (int) (pt.getX()), (int) (pt.getY()));
        textRenderer.draw(""+score, (int) (pt.getX()+10), (int) (pt.getY()-30));
        textRenderer.endRendering();


        GL2 gl = glAutoDrawable.getGL().getGL2();

        // field to display the current one
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
        gl.glVertex2i(700-150,550);
        gl.glVertex2i(700+0, 550);
        gl.glVertex2i(700+0, 680);
        gl.glVertex2i(700-150,680);
        gl.glLoadIdentity();
        gl.glEnd();

        // options

        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
        gl.glVertex2i(85,200);
        gl.glVertex2i(235, 200);
        gl.glVertex2i(235, 330);
        gl.glVertex2i(85,330);
        gl.glLoadIdentity();
        gl.glEnd();

        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
        gl.glVertex2i(245,200);
        gl.glVertex2i(395, 200);
        gl.glVertex2i(395, 330);
        gl.glVertex2i(245,330);
        gl.glLoadIdentity();
        gl.glEnd();

        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
        gl.glVertex2i(405,200);
        gl.glVertex2i(555, 200);
        gl.glVertex2i(555, 330);
        gl.glVertex2i(405,330);
        gl.glLoadIdentity();
        gl.glEnd();

        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
        gl.glVertex2i(565,200);
        gl.glVertex2i(715, 200);
        gl.glVertex2i(715, 330);
        gl.glVertex2i(565,330);
        gl.glLoadIdentity();
        gl.glEnd();




        List<Integer> polygonSides = radom();
        List<Integer> objectColor = ramdomicObject();
        List<Integer> objectSides = ramdomicObject();

        createPolygon(gl,colorsList.get(objectColor.get(0)), polygonSides.get(objectSides.get(0)), 620, 615);
        gl.glLoadIdentity();
        gl.glEnd();

        createPolygon(gl, colorsList.get(objectColor.get(0)), polygonSides.get(0), 160,265);
        gl.glLoadIdentity();
        gl.glEnd();


        createPolygon(gl, colorsList.get(objectColor.get(0)), polygonSides.get(1), 320,265);
        gl.glLoadIdentity();
        gl.glEnd();

        createPolygon(gl, colorsList.get(objectColor.get(0)), polygonSides.get(2), 480, 265);
        gl.glLoadIdentity();
        gl.glEnd();


        createPolygon(gl, colorsList.get(objectColor.get(0)), polygonSides.get(3) ,640 ,265);
        gl.glLoadIdentity();
        gl.glEnd();





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

    public void createPolygon(GL2 gl, Colors color, int sides, int x, int y){
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(color.getR(),color.getG(),color.getB());
        for(int i=0;i<sides;++i){
            double angulo= (2*Math.PI*i/sides);
            gl.glVertex2d(x+ 63*Math.cos(angulo),y+63*Math.sin(angulo));
        }
    }

    private List<Integer> radom(){

        List<Integer> values = Arrays.asList(3,4,5,6,7);
        Collections.shuffle(values);
        return values;
    }
    private List<Integer> ramdomicObject
            (){

        List<Integer> values = Arrays.asList(0,1,2,3);
        Collections.shuffle(values);
        return values;
    }
    private List<Colors> colorsRandom(){

        Collections.shuffle(colorsList);
        return colorsList;
    }

}
