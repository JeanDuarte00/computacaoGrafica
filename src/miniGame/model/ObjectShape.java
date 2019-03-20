package miniGame.model;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLEventListener;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ObjectShape {

    private GraphicsContext context;

    public ObjectShape(GraphicsContext context){
        this.context = context;
    }

    public void rectangle(double lineWidth, Color color, double borderRadius, Position position, Dimension dimension ){
        context.setLineWidth(lineWidth);
        context.setFill(color);
        context.fillRoundRect(position.getX(), position.getY(), dimension.getWidth(), dimension.getHeight(), borderRadius, borderRadius);

    }

    public void line () {

    }



}
