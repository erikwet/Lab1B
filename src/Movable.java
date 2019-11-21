/**
 *
 */
public abstract class Movable implements IMovable {

    private Direction currentDirection; // Direction the car is facing
    private double x; // x position of car
    private double y; // y position of car
    private double currentSpeed; // The current speed of the car

    /**
     * Constructor for class Movable.
     * @param currentDirection Direction a movable object is currently facing.
     * @param x X position a
     * @param y
     */
    public Movable(Direction currentDirection, double x, double y) {
        this.currentDirection = currentDirection;
    }

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

    @Override
    public double getX(){ return x; }


    @Override
    public double getY(){ return y; }


    @Override
    public void setX(double x){ this.x = x; }


    @Override
    public void setY(double y){ this.y = y; }


    @Override
    public Direction getCurrentDirection() { return currentDirection; }


    @Override
    public void setCurrentDirection(Direction currentDirection) { this.currentDirection = currentDirection; }

    /**
     * Gets current speed of a movable object.
     * @return Current speed of a movable object.
     */
    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Sets current speed of a movable object.
     * @param currentSpeed Sets current speed of a movable object.
     */
    @Override
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
