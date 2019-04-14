package miniGame.model.configuration;

public class Axis {

    private double y;
    private double x;
    private double z;

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setZ(double z) {
        this.z = z;
    }

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
