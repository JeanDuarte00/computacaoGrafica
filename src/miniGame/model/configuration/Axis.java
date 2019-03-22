package miniGame.model.configuration;

public class Axis {

    private double y;
    private double x;
    private double z;

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double getZ() {
        return z;
    }



    public Axis(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
