package miniGame.model.shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import miniGame.model.configuration.Position;

public class Quadrilater implements GLEventListener {

    Position p1;
    Position p2;
    Position p3;
    Position p4;


    public Quadrilater ( Position p1, Position p2, Position p3, Position p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        gl.glBegin(GL2.GL_QUADS);

        gl.glVertex3d(-1*p1.getX(), -1*p1.getY(),  0);
        gl.glVertex3d( p2.getX(), -1*p2.getY(),  0);
        gl.glVertex3d( p3.getX(),  p3.getY(),  0);
        gl.glVertex3d(-1*p4.getX(),  p4.getY(),  0);

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