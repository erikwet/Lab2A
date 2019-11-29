package Model;

import java.awt.*;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Subclass of Model.FlatbedTruck
 */
public class Scania extends FlatbedTruck {

    /**
     *
     */
    public Scania() {
        super(Direction.EAST, 0,250, 2, 500, Color.cyan, "ScaniaG530", 2.5, 5, 10, 70);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.002;
    }
}
