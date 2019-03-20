package miniGame.model;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import javafx.geometry.Pos;

public class Square implements GLEventListener {

    Position p1;
    Position p2;
    Position p3;
    Position p4;
    Position p5;

    public Square ( Position p1, Position p2, Position p3, Position p4, Position p5) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin(GL2.GL_QUADS);



        gl.glVertex2d( p1.getX(), p1.getY());
        gl.glVertex2d((-1)*p2.getX(),p2.getY());
        gl.glVertex2d( p4.getX(),(-1)*p4.getY());
        gl.glVertex2d((-1)*p3.getX(),(-1)*p3.getY());

        gl.glEnd();
        gl.glFlush();
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        //method body
    }

    @Override
    public void init(GLAutoDrawable arg0) {
        // method body
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }
}