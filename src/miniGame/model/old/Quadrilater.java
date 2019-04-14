package miniGame.model.old;

import com.jogamp.opengl.GL2;
import miniGame.model.configuration.Position;
import miniGame.model.shapes.Shape;


public class Quadrilater extends Shape {

    private Position p1;
    private Position p2;
    private Position p3;
    private Position p4;

    public Quadrilater ( int id, Position p1, Position p2, Position p3, Position p4) {
        this.id = id;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public void draw(GL2 gl) {

        gl.glTranslated(this.axis.getX(), this.axis.getY(), 0);
        gl.glColor4d(this.color.getRed(),this.color.getGreen(),this.color.getBlue(), 1);

        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(-1*p1.getX(), -1*p1.getY(),  0);
        gl.glVertex3d( p2.getX(), -1*p2.getY(),  0);
        gl.glVertex3d( p3.getX(),  p3.getY(),  0);
        gl.glVertex3d(-1*p4.getX(),  p4.getY(),  0);
        gl.glEnd();


    }
}