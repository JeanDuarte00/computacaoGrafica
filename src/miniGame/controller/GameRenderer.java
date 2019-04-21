package miniGame.controller;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import miniGame.model.enums.Colors;
import miniGame.model.utils.Axis;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class GameRenderer implements GLEventListener {


    private  List<Integer> positions ;
    private Colors color;
    private  int correctPosition;
    List<Shape> shapes;
    private static float score = 0;
    private static int life = 3;
    private static List<Colors> colorsList= Arrays.asList(Colors.VERMELHO,Colors.LARANJA,Colors.AZUL,Colors.VERDE);
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static float timer=0;
    private static float frames = 420;



    public void setTimer(float timer) {
        this.timer = timer;
    }

    public static void setTimer(int time) {
        timer  = time;
    }

    public void resetFrames() {
        frames = 420;
    }

    public static float getFrames() {
        return frames;
    }

    public static void setFrames(float frames) {
        GameRenderer.frames = frames;
    }

    public static float getTimer() {
        return timer;
    }

    public void setLife (int life){
        this.life = life;
    }

    public static int getLife() {
        return life;
    }

    public void resetLife() {
        life = 3;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public static float getScore() {
        return score;
    }

    public int getResultPosition() {
        return correctPosition;
    }

    public void upScore (float up) {
        this.score  = this.score + up ;
    }
    public void downlife() {
        this.life  = this.life -1 ;
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
        GL2 gl = glAutoDrawable.getGL().getGL2();
        Axis pt = new Axis(85, 700, 0);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT| GL.GL_DEPTH_BUFFER_BIT);
        textRenderer.draw("Score: ", (int) (pt.getX()), (int) (pt.getY()));
        textRenderer.draw("" + df.format(score), (int) (pt.getX() + 10), (int) (pt.getY() - 30));
        textRenderer.draw("Vidas: ", (int) (pt.getX()+350), (int) (pt.getY()));
        if ( timer > 1 ) {
            textRenderer.draw("TIMEOUT!", (int) (pt.getX()+200), (int) (pt.getY()-250));
            textRenderer.draw("clique na tela para finalizar.", (int) (pt.getX()+200), (int) (pt.getY()-300));
        }
        if (life > 1) {

        }
        textRenderer.draw("" + life, (int) (pt.getX() + 360), (int) (pt.getY() - 30));
        textRenderer.endRendering();


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


        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);    // Set the current drawing color to light blue
        gl.glVertex2f(0.0f,0.0f);
        gl.glVertex2f(0.0f, 100.0f);
        gl.glVertex2f((1.0f-timer)*800, 100);
        gl.glVertex2f((1.0f-timer)*800,0.0f);
        gl.glLoadIdentity();
        gl.glEnd();
        System.out.println(timer);
        timer += 1.0f/frames;

        //posição referencia
        createPolygon(gl,color,positions.get(correctPosition), 620, 615);
        gl.glLoadIdentity();
        gl.glEnd();

        //primeiro objeto
        createPolygon(gl, color, positions.get(0), 160,265);
        gl.glLoadIdentity();
        gl.glEnd();

        //segundo objeto
        createPolygon(gl, color, positions.get(1), 320,265);
        gl.glLoadIdentity();
        gl.glEnd();

        //terceiro objeto
        createPolygon(gl, color, positions.get(2), 480, 265);
        gl.glLoadIdentity();
        gl.glEnd();

        //quarto objeto
        createPolygon(gl, color, positions.get(3) ,640 ,265);
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

    public void createPolygon(GL2 gl, Colors color, Integer sides, int x, int y){
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(color.getR(),color.getG(),color.getB());
        for(int i=0;i<sides;++i){
            double angulo= (2*Math.PI*i/sides);
            gl.glVertex2d(x+ 63*Math.cos(angulo),y+63*Math.sin(angulo));
        }

    }
    private void drawObject(){

    }
    private List<Integer> randomSides(){

        List<Integer> values = Arrays.asList(3,4,5,6,7);
        Collections.shuffle(values);
        return values;
    }
    private List<Integer> randomic(){

        List<Integer> values = Arrays.asList(0,1,2,3);
        Collections.shuffle(values);
        return values;
    }

    public void createListAndPosition(){
        positions = randomSides();
        correctPosition = randomic().get(0);
        color = colorsList.get(randomic().get(0));
    }

}
