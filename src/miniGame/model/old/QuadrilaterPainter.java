package miniGame.model.old;

import miniGame.model.utils.Position;

public class QuadrilaterPainter {


    private static int id;


    /*public Quadrilater square (double lengthSize) {
        Quadrilater shape = new Quadrilater(
                id++,
                new Position(lengthSize, lengthSize),
                new Position(lengthSize, lengthSize),
                new Position(lengthSize, lengthSize),
                new Position(lengthSize, lengthSize)

        );
        return shape;
    }*/

    public Quadrilater rectangle (double leftRight, double topBottom) {
        Quadrilater shape = new Quadrilater(
                id++,
                new Position(leftRight, topBottom),
                new Position(leftRight, topBottom),
                new Position(leftRight, topBottom),
                new Position(leftRight, topBottom)
        );
        return shape;
    }



}
