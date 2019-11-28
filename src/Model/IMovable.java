package Model;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Interface for all movable objects in the world.
 * Also extends interface Model.IPositionable.
 */

public interface IMovable extends IPositionable{
    /**
     * Possible directions for movable objects
     */
    enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    /**
     * Sets current direction to an object.
     * @param currentDirection The new direction the object should face.
     */
    void setCurrentDirection(Direction currentDirection);

    /**
     * Returns current direction of object.
     * @return Current direction of object.
     */
    Direction getCurrentDirection();

    /**
     * Sets current speed of object.
     * @param speed The new speed the object should get.
     */
    void setCurrentSpeed(double speed);

    /**
     * Returns current speed of an object.
     * @return Current speed of an object.
     */
    double getCurrentSpeed();

    /**
     * Sets y position for an object.
     * @param y Y position the object should get.
     */
    void setY(double y);

    /**
     * Sets x position for an object.
     * @param x X position the object should get.
     */
    void setX(double x);

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