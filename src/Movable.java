public abstract class Movable implements IMovable {

    private Direction currentDirection; // Direction the car is facing
    private double x; // x position of car
    private double y; // y position of car
    private double currentSpeed; // The current speed of the car

    public Movable(Direction currentDirection, double x, double y) {
        this.currentDirection = currentDirection;
    }

    /**
     * Moves Car depending on the direction it's facing. Inherits from Movable interface
     */
    @Override
    public void move() {
        switch (currentDirection){
            case NORTH:
                y += currentSpeed;
                break;
            case EAST:
                x += currentSpeed;
                break;
            case SOUTH:
                y -= currentSpeed;
                break;
            case WEST:
                x -= currentSpeed;
                break;
        }
    }

    /**
     * Turns the car to the left depending on it's current direction. Inherits from Movable interface
     */
    @Override
    public void turnLeft() {
        switch (currentDirection) {
            case NORTH:
                currentDirection = Direction.WEST;
                break;
            case EAST:
                currentDirection = Direction.NORTH;
                break;
            case SOUTH:
                currentDirection = Direction.EAST;
                break;
            case WEST:
                currentDirection = Direction.SOUTH;
                break;
        }
    }

    /**
     * Turns the car to the right depending on it's current direction. Inherits from Movable interface
     */
    @Override
    public void turnRight() {
        switch (getCurrentDirection()) {
            case NORTH:
                currentDirection = Direction.EAST;
                break;
            case EAST:
                currentDirection = Direction.SOUTH;
                break;
            case SOUTH:
                currentDirection = Direction.WEST;
                break;
            case WEST:
                currentDirection = Direction.NORTH;
                break;
        }
    }
    /**
     * Gets x position of car
     * @return x position of car
     */
    @Override
    public double getX(){ return x; }

    /**
     * Gets y position of car
     * @return y position of car
     */
    @Override
    public double getY(){ return y; }

    /**
     * Sets x position for car
     */
    @Override
    public void setX(double x){ this.x = x; }

    /**
     * Sets y position for car
     */
    @Override
    public void setY(double y){ this.y = y; }

    /**
     * Returns current direction of car
     * @return Current direction (the direction the car is currently facing)
     */
    @Override
    public Direction getCurrentDirection() { return currentDirection; }

    /**
     * Sets current direction of car to a valid direction
     * @param currentDirection Current direction of car to set
     */
    @Override
    public void setCurrentDirection(Direction currentDirection) { this.currentDirection = currentDirection; }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
