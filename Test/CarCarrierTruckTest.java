import Model.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CarCarrierTruckTest {

    CarCarrierTruck MANTGXD38 = new MANTGXD38();
    Volvo240 volvo = new Volvo240();
    Scania scania = new Scania();
    Saab95 saab = new Saab95();

    @Test
    public void setCurrentSpeedTest(){
        MANTGXD38.lowerRamp();
        MANTGXD38.gas(1);
        assertEquals(0, MANTGXD38.getCurrentSpeed(), 0.0001);

        MANTGXD38.raiseRamp();
        MANTGXD38.gas(1);
        assertEquals(1, MANTGXD38.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void loadTransportableTest(){

        volvo.setX(50);
        volvo.setY(51);
        MANTGXD38.setX(50);
        MANTGXD38.setY(50);
        MANTGXD38.getTransporterStorageList().clear();
        MANTGXD38.lowerRamp();
        MANTGXD38.loadTransportable(volvo);
        assertEquals(1 , MANTGXD38.getTransporterStorageList().size());

        saab.setX(52);
        saab.setY(50);
        MANTGXD38.raiseRamp();
        MANTGXD38.loadTransportable(saab);
        assertEquals(1, MANTGXD38.getTransporterStorageList().size());

    }

    @Test
    public void transportableFitsTest() {

        assertEquals(true, MANTGXD38.transportableFits(volvo));
    }

    @Test
    public void closeEnoughTest(){
        volvo.setX(100);
        volvo.setY(50);
        MANTGXD38.setX(100);
        MANTGXD38.setY(51);

        assertEquals(true, MANTGXD38.closeEnough(volvo));
    }

    @Test
    public void moveTest(){
        volvo.setX(200);
        volvo.setY(100);
        MANTGXD38.setCurrentDirection(IMovable.Direction.NORTH);
        MANTGXD38.getTransporterStorageList().clear();
        MANTGXD38.lowerRamp();
        MANTGXD38.loadTransportable(volvo);
        MANTGXD38.raiseRamp();
        MANTGXD38.setCurrentSpeed(5);
        MANTGXD38.move();
        assertEquals(95, MANTGXD38.getY(), 0.0001);
        assertEquals(MANTGXD38.getY(), volvo.getY(), 0.0001);
    }

    @Test
    public void transporterIsNotFullTest(){

        MANTGXD38.getTransporterStorageList().clear();

        assertEquals(true, MANTGXD38.transporterIsNotFull());
    }

    @Test
    public void unloadTransportableTest(){

        volvo.setX(10);
        volvo.setY(20);
        MANTGXD38.setX(12);
        MANTGXD38.setY(18);
        MANTGXD38.getTransporterStorageList().clear();
        MANTGXD38.lowerRamp();
        MANTGXD38.loadTransportable(volvo);
        MANTGXD38.unloadTransportable();
        assertEquals(0, MANTGXD38.getTransporterStorageList().size());
    }

}
