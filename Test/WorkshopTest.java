import Model.Car;
import Model.Saab95;
import Model.Volvo240;
import Model.Workshop;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WorkshopTest {

    Workshop<Volvo240> volvoWorkshop = new Workshop<>(10, 2.5, 3, 6, 35, 45);
    Workshop<Car> carWorkshop = new Workshop<>(10, 2.5, 3, 6, 20, 55);

    Volvo240 volvo = new Volvo240();
    Saab95 saab = new Saab95();

    @Test
    public void loadTransportableTest(){
        volvo.setY(45);
        volvo.setX(35);
        volvoWorkshop.getTransporterStorageList().clear();
        volvoWorkshop.openLoadingPoint();
        volvoWorkshop.loadTransportable(volvo);
        assertEquals(1, volvoWorkshop.getTransporterStorageList().size());

        //volvoWorkshop.loadTransportable(saab);

        volvo.setY(55);
        volvo.setX(20);
        saab.setY(55);
        saab.setX(20);
        carWorkshop.getTransporterStorageList().clear();
        carWorkshop.openLoadingPoint();
        carWorkshop.loadTransportable(saab);
        carWorkshop.loadTransportable(volvo);

        assertEquals(2, carWorkshop.getTransporterStorageList().size());

    }

    @Test
    public void unloadTransportableTest(){

        volvo.setY(45);
        volvo.setX(35);
        volvoWorkshop.getTransporterStorageList().clear();
        volvoWorkshop.openLoadingPoint();
        volvoWorkshop.loadTransportable(volvo);
        volvoWorkshop.unloadTransportable();
        assertEquals(0, volvoWorkshop.getTransporterStorageList().size());

    }
}
