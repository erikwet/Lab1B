/**
 * Interface for all transportable objects in the world.
 * Also extends interface IMovable.
 */
public interface ITransportable extends IMovable {
    /**
     * Gets width for a transportable object.
     * @return The width of a transportable object.
     */
    double getWidth();

    /**
     * Gets height for a transportable object.
     * @return The height of a transportable object.
     */
    double getHeight();

    /**
     * Gets length for a transportable object.
     * @return The length of a transportable object.
     */
    double getLength();
}
