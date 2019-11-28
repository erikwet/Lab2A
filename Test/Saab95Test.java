import Model.Saab95;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Saab95Test {

    Saab95 saab = new Saab95();

    @Test
    public void TurboTest(){
        saab.setTurboOn();
        saab.setCurrentSpeed(0);
        saab.gas(1);
        assertEquals(1.625, saab.getCurrentSpeed(), 0.001);

        saab.setTurboOff();
        saab.setCurrentSpeed(0);
        saab.gas(1);
        assertEquals(1.25, saab.getCurrentSpeed(), 0.001);

        saab.setTurboOn();
        saab.setCurrentSpeed(5);
        saab.brake(1);
        assertEquals(3.375, saab.getCurrentSpeed(), 0.001);

        saab.setTurboOff();
        saab.setCurrentSpeed(5);
        saab.brake(1);
        assertEquals(3.75, saab.getCurrentSpeed(), 0.001);
    }
}
