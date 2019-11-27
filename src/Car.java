import java.awt.*;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Superclass to all Car subobjects
 */
public class Car extends MotorizedVehicle implements ITransportable {

    public Car(Direction currentDirection, double x, double y, int nrDoors, double enginePower, Color color, String modelName, double widthMeter, double heightMeter, double lengthMeter) {
        super(currentDirection, x, y, nrDoors, enginePower, color, modelName, widthMeter, heightMeter, lengthMeter);
    }
}
