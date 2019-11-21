import java.awt.*;

public class FlatbedTruck extends MotorizedVehicle {

    private int flatbedAngle;
    private int flatbedAngleMax;

    public FlatbedTruck(Direction currentDirection, double x, double y, int nrDoors, double enginePower, Color color, String modelName, int flatbedAngleMax) {
        super(currentDirection, x, y, nrDoors, enginePower, color, modelName);
        this.flatbedAngleMax = flatbedAngleMax;
    }

    public void lowerFlatbed(){
        setFlatbedAngle(flatbedAngle - 1);
    }

    public void raiseFlatbed(){
        setFlatbedAngle(flatbedAngle + 1);
    }

    public int getFlatbedAngle() {
        return flatbedAngle;
    }

    public void setFlatbedAngle(int angle) {
        if(getCurrentSpeed() != 0) {
            setFlatbedAngle(0);
        } else {
            angle = Math.min(angle, flatbedAngleMax);
            flatbedAngle = Math.max(angle, 0);
        }
    }

    @Override
    public void setCurrentSpeed(double speed){
        if(flatbedAngle != 0) {
            super.setCurrentSpeed(0);
        }else {
            super.setCurrentSpeed(speed);
        }
    }
}
