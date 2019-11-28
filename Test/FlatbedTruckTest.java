import Model.Scania;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FlatbedTruckTest {

    Scania scania = new Scania();

    @Test
    public void LowerFlatbedTest(){
        scania.setFlatbedAngle(35);
        scania.lowerFlatbed();
        assertEquals(34, scania.getFlatbedAngle());

        scania.setFlatbedAngle(0);
        scania.lowerFlatbed();
        assertEquals(0, scania.getFlatbedAngle());
    }

    @Test
    public void RaiseFlatbedTest(){
        scania.setFlatbedAngle(35);
        scania.raiseFlatbed();
        assertEquals(36, scania.getFlatbedAngle());

        scania.setFlatbedAngle(70);
        scania.raiseFlatbed();
        assertEquals(70, scania.getFlatbedAngle());
    }

    @Test
    public void setFlatbedAngleTest(){

        scania.setFlatbedAngle(71);
        assertEquals(70, scania.getFlatbedAngle());

        scania.setFlatbedAngle(-1);
        assertEquals(0, scania.getFlatbedAngle());

    }

    @Test
    public void setCurrentSpeedTest(){

        scania.setFlatbedAngle(4);
        scania.setCurrentSpeed(50);
        assertEquals(0, scania.getCurrentSpeed(), 0.001);

        scania.setCurrentSpeed(0);
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed(), 0.001);

    }

}
