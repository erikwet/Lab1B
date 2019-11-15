public interface IMovable {
    /**
     * Possible directions for objects
     */
    enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    double getX();

    double getY();

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