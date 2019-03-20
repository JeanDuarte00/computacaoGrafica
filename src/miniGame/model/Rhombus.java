package miniGame.model;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Rhombus implements GLEventListener {

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        //edge1
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0.0f, 0.75f, 0);
        gl.glVertex3f(-0.75f, 0f, 0);
        gl.glEnd();

        //edge2
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.75f, 0f, 0);
        gl.glVertex3f(0f, -0.75f, 0);
        gl.glEnd();

        //edge3
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0f, -0.75f, 0);
        gl.glVertex3f(0.75f, 0f, 0);
        gl.glEnd();

        //edge4
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0.75f, 0f, 0);
        gl.glVertex3f(0.0f, 0.75f, 0);
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