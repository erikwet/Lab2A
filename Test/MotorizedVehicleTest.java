import static org.junit.Assert.assertEquals;

import Model.IMovable;
import Model.Saab95;
import Model.Volvo240;
import org.junit.Test;


public class MotorizedVehicleTest {

    Volvo240 volvo = new Volvo240();
    Saab95 saab = new Saab95();

    @Test
    public void testTurnLeft() {

        volvo.setCurrentDirection(IMovable.Direction.NORTH);
        volvo.turnLeft();
        assertEquals(IMovable.Direction.WEST, volvo.getCurrentDirection());
        volvo.turnLeft();
        assertEquals(IMovable.Direction.SOUTH, volvo.getCurrentDirection());
        volvo.turnLeft();
        assertEquals(IMovable.Direction.EAST, volvo.getCurrentDirection());
        volvo.turnLeft();
        assertEquals(IMovable.Direction.NORTH, volvo.getCurrentDirection());

        saab.setCurrentDirection(IMovable.Direction.NORTH);
        saab.turnLeft();
        assertEquals(IMovable.Direction.WEST, saab.getCurrentDirection());
        saab.turnLeft();
        assertEquals(IMovable.Direction.SOUTH, saab.getCurrentDirection());
        saab.turnLeft();
        assertEquals(IMovable.Direction.EAST, saab.getCurrentDirection());
        saab.turnLeft();
        assertEquals(IMovable.Direction.NORTH, saab.getCurrentDirection());
    }

    @Test
    public void testTurnRight() {
        volvo.setCurrentDirection(IMovable.Direction.NORTH);
        volvo.turnRight();
        assertEquals(IMovable.Direction.EAST, volvo.getCurrentDirection());
        volvo.turnRight();
        assertEquals(IMovable.Direction.SOUTH, volvo.getCurrentDirection());
        volvo.turnRight();
        assertEquals(IMovable.Direction.WEST, volvo.getCurrentDirection());
        volvo.turnRight();
        assertEquals(IMovable.Direction.NORTH, volvo.getCurrentDirection());

        saab.setCurrentDirection(IMovable.Direction.NORTH);
        saab.turnRight();
        assertEquals(IMovable.Direction.EAST, saab.getCurrentDirection());
        saab.turnRight();
        assertEquals(IMovable.Direction.SOUTH, saab.getCurrentDirection());
        saab.turnRight();
        assertEquals(IMovable.Direction.WEST, saab.getCurrentDirection());
        saab.turnRight();
        assertEquals(IMovable.Direction.NORTH, saab.getCurrentDirection());
    }

    @Test
    public void testMove() {
        volvo.setCurrentDirection(IMovable.Direction.NORTH);
        volvo.setY(0);
        volvo.setCurrentSpeed(5);
        volvo.move();
        assertEquals(-5, volvo.getY(), 0.001);

        saab.setCurrentDirection(IMovable.Direction.EAST);
        saab.setX(0);
        saab.setCurrentSpeed(5);
        saab.move();
        assertEquals(5, saab.getX(), 0.001);
    }

    @Test
    public void testGas() {
        volvo.setCurrentSpeed(106);
        volvo.gas(0);
        assertEquals(100, volvo.getCurrentSpeed(), 0.0001);

        volvo.setCurrentSpeed(0);
        volvo.gas(2);
        assertEquals(1.25, volvo.getCurrentSpeed(), 0.0001);

        saab.setCurrentSpeed(50);
        saab.gas(1);
        assertEquals(51.25, saab.getCurrentSpeed(), 0.0001);

        saab.setCurrentSpeed(-50);
        saab.gas(1);
        assertEquals(1.25, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void testBrake() {
        volvo.setCurrentSpeed(100);
        volvo.brake(1);
        assertEquals(98.75, volvo.getCurrentSpeed(), 0.0001);

        saab.setCurrentSpeed(100);
        saab.brake(2);
        assertEquals(98.75, saab.getCurrentSpeed(), 0.0001);

        saab.setTurboOn();
        saab.setCurrentSpeed(100);
        saab.brake(1);
        assertEquals(98.375, saab.getCurrentSpeed(), 0.0001);

        saab.setTurboOff();
        saab.setCurrentSpeed(100);
        saab.brake(1);
        assertEquals(98.75, saab.getCurrentSpeed(), 0.0001);
    }
    @Test
    public void test(){
        volvo.setCurrentDirection(IMovable.Direction.SOUTH);
        volvo.oppositeDirection();
        assertEquals(IMovable.Direction.NORTH, volvo.getCurrentDirection());
    }
}