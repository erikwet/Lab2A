package Model;

import java.awt.*;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Abstract superclass to all MotorizedVehicles
 */
public class MotorizedVehicle extends Movable{

    private final int nrDoors; // Number of doors on a motorized vehicle
    private final double enginePower; // Engine power of a motorized vehicle
    private final Color color; // Color of a motorized vehicle
    private final String modelName; // The motorized vehicle model name
    private final double widthMeter; // Width in meter of a motorized vehicle
    private final double heightMeter; // Height in meter of a motorized vehicle
    private final double lengthMeter; //

    /**
     *
     * Constructor for Model.MotorizedVehicle class
     * @param x x Position in world
     * @param y y Position in world
     * @param nrDoors Number of doors on a motorized vehicle
     * @param enginePower Engine power of a motorized vehicle
     * @param color Color of a motorized vehicle
     * @param modelName Model name of a motorized vehicle
     * @param widthMeter Width in meters of a motorized vehicle
     * @param heightMeter Height in meters of a motorized vehicle
     * @param lengthMeter Length in meters of a motorized vehicle
     */
    public MotorizedVehicle(Direction currentDirection, double x, double y, int nrDoors, double enginePower, Color color, String modelName, double widthMeter, double heightMeter, double lengthMeter) {
        super(currentDirection, x, y);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.widthMeter = widthMeter;
        this.heightMeter = heightMeter;
        this.lengthMeter = lengthMeter;
        stopEngine();
    }

    /**
     * Increases speed of motorized vehicle depending on amount by calling on incrementSpeed
     * @param amount Amount the speed should be increased with
     */
    public void gas(double amount) {
        if(getCurrentSpeed() != 0){
        amount = Math.max(amount, 0);
        incrementSpeed(Math.min(amount, 1));
        }
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
     * @return Returns speed factor
     */
    protected double speedFactor() { return (getEnginePower() * 0.01); }

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

    /**
     * Gets width of motorized vehicle in meters
     * @return Width in meters
     */
    public double getWidthMeter() {
        return widthMeter;
    }

    /**
     * Gets height of motorized vehicle in meters
     * @return Height in meters
     */
    public double getHeightMeter() {
        return heightMeter;
    }

    /**
     * Gets length of motorized vehicle in meters
     * @return Length in meters
     */
    public double getLengthMeter() {
        return lengthMeter;
    }
}