import java.awt.*;

public class CarCarrierTruck extends MotorizedVehicle {

    private boolean isRampUp;

    public CarCarrierTruck(int nrDoors, double enginePower, Color color, String modelName) {
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
}
