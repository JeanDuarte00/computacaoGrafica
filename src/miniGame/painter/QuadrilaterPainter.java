package miniGame.painter;

import miniGame.model.configuration.Position;
import miniGame.model.shapes.Quadrilater;

public class QuadrilaterPainter {


    public Quadrilater square (double lengthSize) {
        Quadrilater shape = new Quadrilater(
                new Position(lengthSize, lengthSize),
                new Position(lengthSize, lengthSize),
                new Position(lengthSize, lengthSize),
                new Position(lengthSize, lengthSize)
        );
        return shape;
    }

    public Quadrilater rectangle (double leftRight, double topBottom) {
        Quadrilater shape = new Quadrilater(
                new Position(leftRight, topBottom),
                new Position(leftRight, topBottom),
                new Position(leftRight, topBottom),
                new Position(leftRight, topBottom)
        );
        return shape;
    }



}
