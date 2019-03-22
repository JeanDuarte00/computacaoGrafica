package miniGame.model.configuration;


public class ColorPainter {

    private double red;
    private double gree;
    private double blue;

    public double getRed() {
        return red;
    }

    public double getGree() {
        return gree;
    }

    public double getBlue() {
        return blue;
    }


    public ColorPainter(double red, double green, double blue){

        this.red = red;
        this.gree = green;
        this.blue = blue;
    }


}
