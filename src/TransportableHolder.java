import java.util.Deque;

public class TransportableHolder implements ITransportableHolder {

    private Deque<ITransportable> transporterStorageList;
    private int maxStoredObjects;
    private double maxTransportableWidth;
    private double maxTransportableHeight;
    private double maxTransportableLength;
    private boolean isLoadingPointOpen;
    private double x;
    private double y;

    public TransportableHolder(int maxStoredObjects, double maxTransportableWidth, double maxTransportableHeight, double maxTransportableLength, double x, double y, Deque<ITransportable> transporterStorageList) {
        this.maxStoredObjects = maxStoredObjects;
        this.maxTransportableWidth = maxTransportableWidth;
        this.maxTransportableHeight = maxTransportableHeight;
        this.maxTransportableLength = maxTransportableLength;
        this.x = x;
        this.y = y;
        this.transporterStorageList = transporterStorageList;
    }

    public void openLoadingPoint (){
        isLoadingPointOpen = true;
    }

    public void closeLoadingPoint(){
        isLoadingPointOpen = false;
    }

    public void loadTransportable(ITransportable transportable){
        if (transporterIsNotFull() && transportableFits(transportable) && closeEnough(transportable) && !isLoadingPointOpen){
            transporterStorageList.add(transportable);
        }
    }
    public void unloadTransportable(){
        if(!isLoadingPointOpen) {
            ITransportable unloadedTransportable = transporterStorageList.pop();
            unloadedTransportable.setX(getX()+3);
        }
    }

    public boolean transportableFits(ITransportable transportable){
        return transportable.getWidth() <= maxTransportableWidth &&
                transportable.getHeight() <= maxTransportableHeight &&
                transportable.getLength() <= maxTransportableLength; }

    public boolean transporterIsNotFull(){ return transporterStorageList.size() < maxStoredObjects; }

    public boolean closeEnough(ITransportable transportable){
        return transportable.getX() >= getX()-5 &&
                transportable.getX() <= getX()+5 &&
                transportable.getY() >= getY()-5 &&
                transportable.getY() <= getY()+5;
    }

    public void updateStoredObjectsPosition(){
        for(ITransportable transportable : transporterStorageList){
            transportable.setX(getX());
            transportable.setY(getY());
        }
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }
}
