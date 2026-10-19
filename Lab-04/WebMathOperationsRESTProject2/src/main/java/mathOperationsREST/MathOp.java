package mathOperationsREST;

public class MathOp {

    private double x;
    private double y;
    private double z;

    public MathOp() {
    }

    public MathOp(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double calculateSum() {
        return x + 2 * y + 3 * z;
    }

    public double calculatePrd() {
        return x * 2 * y * 3 * z;
    }
}