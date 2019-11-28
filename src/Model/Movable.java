package Model;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Abstract super class of all movable objects
 */
public abstract class Movable implements IMovable {

    private Direction currentDirection; // Direction the car is facing
    private double x; // x position of car
    private double y; // y position of car
    private double currentSpeed; // The current speed of the car

    /**
     * Constructor for class Model.Movable.
     * @param currentDirection Direction a movable object is currently facing.
     * @param x X position of an object in world
     * @param y Y position of an object in world
     */
    public Movable(Direction currentDirection, double x, double y) {
        this.currentDirection = currentDirection;
        this.x = x;
        this.y = y;
    }

    /**
     * Makes object move in current direction
     */
    @Override
    public void move() {
        switch (currentDirection){
            case NORTH:
                y -= currentSpeed;
                break;
            case EAST:
                x += currentSpeed;
                break;
            case SOUTH:
                y += currentSpeed;
                break;
            case WEST:
                x -= currentSpeed;
                break;
        }
    }

    /**
     * Makes object turn opposite direction from it's current direction
     */
    public void oppositeDirection() {
        switch(currentDirection) {
            case NORTH:
                currentDirection = Direction.SOUTH;
                break;
            case EAST:
                currentDirection = Direction.WEST;
                break;
            case SOUTH:
                currentDirection = Direction.NORTH;
                break;
            case WEST:
                currentDirection = Direction.EAST;
                break;
        }
    }

    /**
     * Makes object turn left depending on current direction
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
     * Makes object turn right depending on current direction
     */
    @Override
    public void turnRight() {
        switch (currentDirection) {
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
     * Gets x position for a object in the world.
     * @return X position of a object in the world.
     */
    @Override
    public double getX(){ return x; }

    /**
     * Gets y position for a object in the world.
     * @return Y position of a object in the world.
     */
    @Override
    public double getY(){ return y; }

    /**
     * Sets x position for an object.
     * @param x X position the object should get.
     */
    @Override
    public void setX(double x){ this.x = x; }

    /**
     * Sets y position for an object.
     * @param y Y position the object should get.
     */
    @Override
    public void setY(double y){ this.y = y; }

    /**
     * Returns current direction of object.
     * @return Current direction of object.
     */
    @Override
    public Direction getCurrentDirection() { return currentDirection; }

    /**
     * Sets current direction to an object.
     * @param currentDirection The new direction the object should face.
     */
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
