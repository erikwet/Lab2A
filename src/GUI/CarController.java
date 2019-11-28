package GUI;

import Model.MotorizedVehicle;
import Model.Saab95;
import Model.Scania;
import Model.Volvo240;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<MotorizedVehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorizedVehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                if(outOfBounds(x,y, frame.drawPanel.carImages.get(0))) {
                    car.stopEngine();
                    setInBounds(car, frame.drawPanel.carImages.get(0));
                    car.oppositeDirection();
                    car.startEngine();
                }
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorizedVehicle car : cars
                ) {
            car.gas(gas);
        }
    }

    /**
     * Calls the brake method for each  car once
     * @param amount The amount of "power" the cars will brake with
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorizedVehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    /**
     * Check if a car image is out of bounds
     * @param x X position of image
     * @param y Y position of image
     * @param carImage image of a car
     * @return True or False if the car is out of bounds
     */
    boolean outOfBounds(int x, int y, BufferedImage carImage){
        return x < 0 || x > (frame.drawPanel.getWidth()-carImage.getWidth()) || y < 0 || y > (frame.drawPanel.getHeight()-carImage.getHeight());
    }

    /**
     * Places a car in bounds
     * @param car The car that will be move in bounds
     * @param carImage The image of the car
     */
   public void setInBounds(MotorizedVehicle car, BufferedImage carImage){
        double x = (Math.min((frame.drawPanel.getWidth()-carImage.getWidth()), car.getX()));
        car.setX(Math.max(0, x));
        double y = (Math.min((frame.drawPanel.getHeight()-carImage.getHeight()), car.getY()));
        car.setY(Math.max(0, y));
    }
}
