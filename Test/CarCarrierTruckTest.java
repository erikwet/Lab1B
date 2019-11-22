import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.awt.*;

public class CarCarrierTruckTest {

    CarCarrierTruck carCarrierTruck = new CarCarrierTruck(IMovable.Direction.NORTH, 50, 50, 2, 600, Color.gray, "CarCarrier", 2.5, 6, 8, 5, 2.3, 5, 4);
    Volvo240 volvo = new Volvo240();
    @Test
    public void setCurrentSpeedTest(){
        carCarrierTruck.lowerRamp();
        carCarrierTruck.gas(1);
        assertEquals(0, carCarrierTruck.getCurrentSpeed(), 0.0001);

        carCarrierTruck.raiseRamp();
        carCarrierTruck.gas(1);
        assertEquals(1, carCarrierTruck.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void loadTransportableTest(){
        carCarrierTruck.loadTransportable();
    }
}
