import java.awt.*;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Subclass of Car. Represents a car of model Volvo240
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(Direction.NORTH, 25, 25, 5, 100, Color.white, "Volvo240", 1.8, 1.6, 4.5);
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