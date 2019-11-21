import java.awt.*;
import java.util.Deque;
import java.util.List;

public class CarCarrierTruck extends MotorizedVehicle {

    public CarCarrierTruck(int nrDoors, double enginePower, Color color, String modelName, int maxStoredObjects, int maxTransportableWidth, int maxTransportableHeight, int maxTransportableLength) {
        super(nrDoors, enginePower, color, modelName);
    }

    public void raiseRamp(){
        isRampUp = true;
    }

    public void lowerRamp(){
        if(getCurrentSpeed() == 0) {
            isRampUp = false;
        }
    }

    @Override
    public void setCurrentSpeed(double speed){
        if(!isRampUp) {
            super.setCurrentSpeed(0);
        }else {
            super.setCurrentSpeed(speed);
        }
    }

    @Override
    public void move(){
        super.move();
        updateStoredObjectsPosition();
    }
}
