package miniGame.model.shapes;

import com.jogamp.opengl.GL2;

public class Square extends Shape {

    int dimension = 4;


    public void draw(GL2 gl) {

        gl.glTranslated(this.axis.getX(), this.axis.getY(), 0);
        gl.glColor4d(this.color.getRed(),this.color.getGreen(),this.color.getBlue(), 1);

        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(-1*this.getAxis().getX()-dimension, -1*this.getAxis().getY()-dimension,  0);
        gl.glVertex3d( this.getAxis().getX()+dimension, -1*this.getAxis().getY()-dimension,  0);
        gl.glVertex3d( this.getAxis().getX()+dimension,  this.getAxis().getY()+dimension,  0);
        gl.glVertex3d(-1*this.getAxis().getX()-dimension,  this.getAxis().getY()+dimension,  0);
        gl.glEnd();


        // gl.glVertex3d(-1*p1.getX(), -1*p1.getY(),  0);

        gl.glEnd();


    }


}
