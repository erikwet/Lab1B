import java.awt.*;

/**
 * @author Oscar Arvidson och Erik Wetter
 * Abstract superclass to all Car subobjects
 */
public abstract class MotorizedVehicle extends Movable{
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private final Color color; // Color of the car
    private final String modelName; // The car model name


    /**
     * Constructor for Car class
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
     * Increases speed of car depending on amount by calling on incrementSpeed
     * @param amount Amount the speed should be increased with
     */
    public void gas(double amount) {
        amount = Math.max(amount, 0);
        incrementSpeed(Math.min(amount, 1));
    }

    /**
     * Decreases speed of car depending on amount by calling on decrementSpeed
     * @param amount Amount the speed should be decreased with
     */
    public void brake(double amount){
        amount = Math.max(amount, 0);
        decrementSpeed(Math.min(amount, 1));
    }

    /**
     * Returns speed factor of car
     * @return Returns speed factor (is overridden in subclasses)
     */
    protected double speedFactor() { return 1; }

    /**
     * Increments speed of car depending on amount
     * @param amount Amount the speed should increment with
     */
    public void incrementSpeed(double amount) { setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount); }

    /**
     * Decrements speed of car depending on amount
     * @param amount Amount the speed should decrement with
     */
    public void decrementSpeed(double amount){ setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount); }

    /**
     * Returns number of doors on car
     * @return number of doors on car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns engine power of car
     * @return Engine power of car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Sets current speed of car to a valid value in the interval [0, enginePower]
     * @param speed Sets current speed of car
     */
    @Override
    public void setCurrentSpeed(double speed) {
        speed = Math.min(speed, enginePower);
        super.setCurrentSpeed(Math.max(speed, 0));
    }

    /**
     * Gets color of car
     * @return Color of car
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