package Model;

import Model.Car;

import java.awt.*;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Subclass of Model.Car. Represents a car of model Model.Saab95
 */
public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(){
        super(Direction.EAST, 0, 150, 5, 125, Color.black, "Model.Saab95", 1.75, 1.53, 4.27);
	    turboOn = false;
    }

    /**
     * Turns on turbo (sets turboOn to true)
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns off turbo (sets turboOn to false)
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Calculates the speed factor (overrides method from Model.Car)
     * @return The speed factor (factor the speed is changed by)
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return super.speedFactor() * turbo;
    }
}