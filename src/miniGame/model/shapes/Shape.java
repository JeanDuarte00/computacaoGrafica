package miniGame.model.shapes;

import com.jogamp.opengl.GL2;
import miniGame.model.configuration.Axis;
import miniGame.model.configuration.ColorPainter;


public abstract class Shape implements Comparable<Shape> {

    protected Integer id;
    protected ColorPainter color;
    protected Axis axis;
    protected int nLados;


    public int getLado () {
        return this.nLados;
    }

    public Integer getId() {
        return id;
    }

    public ColorPainter getColor() {
        return color;
    }

    public Axis getAxis() {
        return axis;
    }


    public abstract void draw(GL2 gl);

    public void setAxis( Axis axis ) {
        this.axis = axis;
    }

    public void setColor (ColorPainter color) {

        this.color = color;
    }


    @Override
    public int compareTo(Shape shape) {
        return this.getId().compareTo( shape.getId() );
    }

}
