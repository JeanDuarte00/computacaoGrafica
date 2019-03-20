package miniGame.model.shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import miniGame.model.configuration.Position;

public class Triangle implements GLEventListener {
    Position p1;
    Position p2;
    Position p3;

    public Triangle(Position p1, Position p2, Position p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glBegin(GL2.GL_TRIANGLES);

        gl.glVertex3d(p1.getX(), p1.getY(),0);
        gl.glVertex3d(-1*p2.getX(), -1*p2.getY(), 0);
        gl.glVertex3d(p3.getX(),-1*p3.getY(),0);

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
