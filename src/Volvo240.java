import java.awt.*;

/**
 * @author SOME
 * Subclass of Car. Represents a car of model Volvo240
 */
public class Volvo240 extends MotorizedVehicle {

    private final static double trimFactor = 1.25;

    /**
     * Constructor for Volvo240 class
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }

    /**
     * Calculates the speed factor (overrides method from Car)
     * @return The speed factor (factor the speed is changed by)
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}