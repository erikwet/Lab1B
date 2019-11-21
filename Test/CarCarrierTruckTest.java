import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.awt.*;

public class CarCarrierTruckTest {

    CarCarrierTruck carCarrierTruck = new CarCarrierTruck(IMovable.Direction.NORTH, 50, 50, 2, 600, Color.gray, "VolvoCarCarrier", 6, 3, 2.3, 5);

    @Test
    public void setCurrentSpeedTest(){
        carCarrierTruck.setCurrentSpeed(10);
        carCarrierTruck.raiseRamp();

        assertEquals(10,carCarrierTruck.getCurrentSpeed());
    }
}
