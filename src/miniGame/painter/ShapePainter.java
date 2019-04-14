package miniGame.painter;

import com.jogamp.opengl.GL2;
import miniGame.model.shapes.Shape;

public class ShapePainter {

    private Shape shape;
    private int dimension;


    ShapePainter( Shape shape ) {
        this.shape = shape;
    }

    public void draw(GL2 gl) {

        gl.glTranslated(
                this.shape.getAxis().getX(),
                this.shape.getAxis().getX(),
                0
        );
        gl.glColor4d(
                this.shape.getColor().getRed(),
                this.shape.getColor().getGreen(),
                this.shape.getColor().getBlue(),
                1
        );

        gl.glBegin(GL2.GL_QUADS);

        for (int c = 0; c < this.shape.getLado(); c++) {

            gl.glVertex3d(
                    this.shape.getAxis().getX(),
                    this.shape.getAxis().getY(),
                    this.shape.getAxis().getZ()
            );

        }

        // gl.glVertex3d(-1*p1.getX(), -1*p1.getY(),  0);

        gl.glEnd();


    }

}
