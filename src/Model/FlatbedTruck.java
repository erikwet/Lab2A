package Model;

import java.awt.*;

/**
 * @author Oscar Arvidson and Erik Wetter
 * A subclass of Model.MotorizedVehicle that consist of methods used in flatbed trucks
 */
public class FlatbedTruck extends MotorizedVehicle {

    private int flatbedAngle;
    private int flatbedAngleMax;

    /**
     * @param x x Position of flatbed truck in world
     * @param y y Position of flatbed truck in world
     * @param nrDoors Number of doors on the flatbed truck
     * @param enginePower Engine power of the flatbed truck
     * @param color Color of the flatbed truck
     * @param modelName Model name of the flatbed truck
     * @param widthMeter Width in meters of the flatbed truck
     * @param heightMeter Height in meters of the flatbed truck
     * @param lengthMeter Length in meters of the flatbed truck
     * @param flatbedAngleMax Max angle of the flatbed
     */
    public FlatbedTruck(Direction currentDirection, double x, double y, int nrDoors, double enginePower, Color color, String modelName, double widthMeter, double heightMeter, double lengthMeter, int flatbedAngleMax) {
        super(currentDirection, x, y, nrDoors, enginePower, color, modelName, widthMeter, heightMeter, lengthMeter);
        this.flatbedAngleMax = flatbedAngleMax;
    }

    /**
     * Decreases the angle of the flatbed
     */
    public void lowerFlatbed(){
        setFlatbedAngle(flatbedAngle - 1);
    }

    /**
     * Increases the angle of the flatbed
     */
    public void raiseFlatbed(){
        setFlatbedAngle(flatbedAngle + 1);
    }

    /**
     * @return The angle of the flatbed
     */
    public int getFlatbedAngle() {
        return flatbedAngle;
    }

    /**
     * Sets the flatbed angle
     * @param angle Angle of flatbed
     */
    public void setFlatbedAngle(int angle) {
        if(getCurrentSpeed() != 0) {
            flatbedAngle = 0;
        } else {
            angle = Math.min(angle, flatbedAngleMax);
            flatbedAngle = Math.max(angle, 0);
        }
    }

    /**
     * Sets current speed of flatbed truck if flatbed is not raised
     * @param speed Sets current speed of flatbed truck
     */
    @Override
    public void setCurrentSpeed(double speed){
        if(flatbedAngle != 0) {
            super.setCurrentSpeed(0);
        }else {
            super.setCurrentSpeed(speed);
        }
    }
}
