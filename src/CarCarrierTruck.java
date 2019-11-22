import java.awt.*;
import java.util.Deque;

/**
 * A subclass of MotorizedVehicle that consist of methods used in car carrier trucks.
 * Also implements the interface ITransportableHolder.
 */
public class CarCarrierTruck extends MotorizedVehicle implements ITransportableHolder{

    private TransportableHolder transportableHolderParent;
    private Deque<ITransportable> transportableStorageList;
    private boolean isRampUp;

    public CarCarrierTruck(Direction currentDirection, double x, double y, int nrDoors, double enginePower, Color color, String modelName, double widthMeter, double heightMeter, double lengthMeter, int maxStoredObjects, double maxTransportableWidth, double maxTransportableHeight, double maxTransportableLength) {
        super(currentDirection, x, y, nrDoors, enginePower, color, modelName, widthMeter, heightMeter, lengthMeter);
        transportableHolderParent = new TransportableHolder(maxStoredObjects, maxTransportableWidth, maxTransportableHeight, maxTransportableLength, x, y, transportableStorageList);
    }

    public void raiseRamp(){
        transportableHolderParent.closeLoadingPoint();
        isRampUp = true;
    }

    public void lowerRamp(){
        if(getCurrentSpeed() == 0) {
            transportableHolderParent.openLoadingPoint();
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

    @Override
    public void loadTransportable(ITransportable transportable) {
        transportableHolderParent.loadTransportable(transportable);
    }

    @Override
    public void unloadTransportable() {
        transportableHolderParent.unloadTransportable();
    }

    @Override
    public boolean transportableFits(ITransportable transportable) {
        return transportableHolderParent.transportableFits(transportable);
    }

    @Override
    public boolean transporterIsNotFull() {
        return transportableHolderParent.transporterIsNotFull();
    }

    @Override
    public boolean closeEnough(ITransportable transportable) {
        return transportableHolderParent.closeEnough(transportable);
    }

    public void updateStoredObjectsPosition(){
        transportableHolderParent.updateStoredObjectsPosition();
    }

}
