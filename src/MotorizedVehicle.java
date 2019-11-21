import java.awt.*;

/**
 * @author Oscar Arvidson och Erik Wetter
 * Abstract superclass to all MotorizedVehicles
 */
public abstract class MotorizedVehicle extends Movable{
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private final Color color; // Color of the car
    private final String modelName; // The car model name


    /**
     * Constructor for MotorizedVehicle class
     * @param x x Position in world
     * @param y y Position in world
     * @param nrDoors Number of doors on a Car
     * @param enginePower Engine power of a Car
     * @param color Color of a Car
     * @param modelName Model name of a Car
     */
    public MotorizedVehicle(Direction currentDirection, double x, double y, int nrDoors, double enginePower, Color color, String modelName) {
        super(currentDirection, x, y);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Increases speed of motorized vehicle depending on amount by calling on incrementSpeed
     * @param amount Amount the speed should be increased with
     */
    public void gas(double amount) {
        amount = Math.max(amount, 0);
        incrementSpeed(Math.min(amount, 1));
    }

    /**
     * Decreases speed of motorized vehicle depending on amount by calling on decrementSpeed
     * @param amount Amount the speed should be decreased with
     */
    public void brake(double amount){
        amount = Math.max(amount, 0);
        decrementSpeed(Math.min(amount, 1));
    }

    /**
     * Returns speed factor of motorized vehicle
     * @return Returns speed factor (is overridden in subclasses)
     */
    protected double speedFactor() { return 1; }

    /**
     * Increments speed of motorized vehicle depending on amount
     * @param amount Amount the speed should increment with
     */
    public void incrementSpeed(double amount) { setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount); }

    /**
     * Decrements speed of motorized vehicle depending on amount
     * @param amount Amount the speed should decrement with
     */
    public void decrementSpeed(double amount){ setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount); }

    /**
     * Returns number of doors on motorized vehicle
     * @return number of doors on motorized vehicle
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns engine power of motorized vehicle
     * @return Engine power of motorized vehicle
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Sets current speed of motorized vehicle to a valid value in the interval [0, enginePower]
     * @param speed Sets current speed of motorized vehicle
     */
    @Override
    public void setCurrentSpeed(double speed) {
        speed = Math.min(speed, enginePower);
        super.setCurrentSpeed(Math.max(speed, 0));
    }

    /**
     * Gets color of motorized vehicle
     * @return Color of motorized vehicle
     */
    public Color getColor(){
        return color;
    }

    /**
     * Starts engine by setting currentSpeed to 0.1
     */
    public void startEngine(){
        super.setCurrentSpeed(0.1);
    }

    /**
     * Stops engine by setting currentSpeed to 0
     */
    public void stopEngine(){
        super.setCurrentSpeed(0);
    }

}