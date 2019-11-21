public interface IMovable extends IPositionable{
    /**
     * Possible directions for objects
     */
    enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    void setCurrentDirection(Direction currentDirection);

    Direction getCurrentDirection();

    void setCurrentSpeed(double speed);

    double getCurrentSpeed();

    /**
     * Makes object move in current direction
     */
    void move();

    /**
     * Makes object turn left depending on current direction
     */
    void turnLeft();

    /**
     * Makes object turn right depending on current direction
     */
    void turnRight();
}