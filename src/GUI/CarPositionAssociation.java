package GUI;

import Model.MotorizedVehicle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CarPositionAssociation {
    MotorizedVehicle car;
    String carImagePath;
    BufferedImage carImage;
    Point carPoint;

    public CarPositionAssociation(MotorizedVehicle car, String carImagePath, Point carPoint){
        this.car = car;
        this.carImagePath = carImagePath;
        this.carPoint = carPoint;
        try {
            this.carImage = ImageIO.read(DrawPanel.class.getResourceAsStream(carImagePath));
        } catch(IOException e){
            e.printStackTrace();
        }

    }

}
