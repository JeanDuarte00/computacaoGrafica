package miniGame.model.old;

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

    public float rotation;

    @Override
    public void display( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear (GL2.GL_COLOR_BUFFER_BIT |  GL2.GL_DEPTH_BUFFER_BIT );

        // Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();  // Reset The View

        //triangle rotation
        gl.glRotatef( rotation, 0.0f, 1.0f, 0.0f );


        gl.glBegin(GL2.GL_TRIANGLES);
        //Green Color
        gl.glColor3f( 0.0f,1.0f,0.0f );
        gl.glVertex3d(p1.getX(), p1.getY(),0);
        gl.glVertex3d(-1*p2.getX(), -1*p2.getY(), 0);
        gl.glVertex3d(p3.getX(),-1*p3.getY(),0);

        gl.glEnd();

        gl.glFlush();
        //Assign the angle
        rotation += 0.6f;
    }

    @Override
    public void dispose( GLAutoDrawable arg0 ) {
        //method body
    }

    @Override
    public void init( GLAutoDrawable arg0 ) {
        // method body
    }

    @Override
    public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
    }

}
