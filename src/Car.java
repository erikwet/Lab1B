import java.awt.*;

public abstract class Car extends MotorizedVehicle implements ITransportable{

    private Transportable transportableParent;

    public Car(Direction currentDirection, double x, double y, int nrDoors, double enginePower, Color color, String modelName, double widthMeter, double heightMeter, double lengthMeter) {
        super(currentDirection, x, y, nrDoors, enginePower, color, modelName);
        transportableParent = new Transportable(widthMeter, heightMeter, lengthMeter);
    }

    @Override
    public double getWidth(){
       return transportableParent.getWidth();
    }

    @Override
    public double getLength(){
        return transportableParent.getLength();
    }

    @Override
    public double getHeight(){
        return transportableParent.getHeight();
    }


}
