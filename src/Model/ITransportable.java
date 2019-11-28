package Model;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Interface for all transportable objects in the world.
 * Also extends interface Model.IMovable.
 */
public interface ITransportable extends IMovable {
    /**
     * Gets width for a transportable object.
     * @return The width of a transportable object.
     */
    double getWidthMeter();

    /**
     * Gets height for a transportable object.
     * @return The height of a transportable object.
     */
    double getHeightMeter();

    /**
     * Gets length for a transportable object.
     * @return The length of a transportable object.
     */
    double getLengthMeter();
}
