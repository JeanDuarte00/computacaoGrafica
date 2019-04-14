package miniGame.model.old;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import miniGame.model.configuration.Position;

public class Polygon implements GLEventListener {
    Position p1;
    Position p2;
    Position p3;
    Position p4;
    Position p5;
    Position p6;
    Position p7;
    Position p8;

    public Polygon(){}

    public Polygon(Position p1, Position p2, Position p3, Position p4, Position p5, Position p6, Position p7, Position p8){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();


        gl.glBegin(GL2.GL_POLYGON);

        gl.glVertex2d( p1.getX(), p1.getY());
        gl.glVertex2d((-1)*p2.getX(), p2.getY());

        gl.glVertex2d((-1)*p3.getX(),(-1)*p3.getY());
        gl.glVertex2d( p4.getX(),(-1)*p4.getY());

        gl.glVertex2d( p5.getX(), p5.getY());
        gl.glVertex2d( p6.getX(), (-1)*p6.getY());


        gl.glVertex2d( p7.getX(),(-1)*p7.getY());
        gl.glVertex2d( p8.getX(),(-1)*p8.getY());



        gl.glEnd();

        gl.glFlush();
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
