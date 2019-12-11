package GUI;

import Model.MotorizedVehicle;
import Model.Saab95;
import Model.Scania;
import Model.Volvo240;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
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


        cc.cars.add(new Saab95());
        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());

        cc.frame = new CarView("CarSim 1.0", cc);

        for (MotorizedVehicle car : cc.cars) {
            String s = "pics/" + car.getModelName() + ".jpg";
            System.out.println(s);
            try {
                cc.frame.drawPanel.carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream(s)));
            }catch(IOException ex) {
                ex.printStackTrace();
            }
        }

        // Start a new view and send a reference of self


        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).move();
                int x = (int) Math.round(cars.get(i).getX());
                int y = (int) Math.round(cars.get(i).getY());
                if(outOfBounds(x,y, frame.drawPanel.carImages.get(0))) {
                    cars.get(i).stopEngine();
                    setInBounds(cars.get(i), frame.drawPanel.carImages.get(0));
                    cars.get(i).oppositeDirection();
                    cars.get(i).startEngine();
                }
                frame.drawPanel.moveit(x, y, i);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                //System.out.println(cars.size());
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
     * Calls the brake method for each car once
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
     * Try to call the setTurboOn method for each car once and runs if car is a Saab95
     */
    void turboOn(){
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Saab95.class){
                Saab95 s = (Saab95) car;
                s.setTurboOn();
            }
        }
    }

    /**
     * Try to call the setTurboOff method for each car once and runs if car is a Saab95
     */
    void turboOff(){
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Saab95.class){
                Saab95 s = (Saab95) car;
                s.setTurboOff();
            }
        }
    }

    /**
     * Try to call the raiseFlatbed method for each car once and runs if car is a Scania
     */
    void raiseFlatbed(){
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Scania.class){
                Scania s = (Scania) car;
                s.raiseFlatbed();
            }
        }
    }

    /**
     * Try to call the lowerFlatbed method for each car once and runs if car is a Scania
     */
    void lowerFlatbed() {
        for(MotorizedVehicle car: cars){
            if(car.getClass() == Scania.class){
                Scania s = (Scania) car;
                s.lowerFlatbed();
            }
        }
    }

    /**
     * Calls the stopEngine method for each car once
     */
    void stopAllCars() {
        for(MotorizedVehicle car: cars){
            car.stopEngine();
        }
    }

    /**
     * Calls the startEngine method for each car once
     */
    void startAllCars() {
        for(MotorizedVehicle car: cars){
            car.startEngine();
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
