import java.util.Deque;

public class TransportableHolder implements ITransportableHolder {

    private Deque<ITransportable> transporterStorageList;
    private int maxStoredObjects;
    private int maxTransportableWidth;
    private int maxTransportableHeight;
    private int maxTransportableLength;
    private boolean isLoadingPointOpen;

    public TransportableHolder(int maxStoredObjects, int maxTransportableWidth, int maxTransportableHeight, int maxTransportableLength) {
        this.maxStoredObjects = maxStoredObjects;
        this.maxTransportableWidth = maxTransportableWidth;
        this.maxTransportableHeight = maxTransportableHeight;
        this.maxTransportableLength = maxTransportableLength;
    }

    public void loadTransportable(ITransportable transportable){
        if (transporterIsNotFull() && transportableFits(transportable) && closeEnough(transportable) && !isLoadingPointOpen){
            transporterStorageList.add(transportable);
        }
    }
    public void unloadTransportable(){
        if(!isLoadingPointOpen) {
            ITransportable unloadedTransportable = transporterStorageList.pop();
            unloadedTransportable.
        }
    }

    public boolean transportableFits(ITransportable transportable){
        return transportable.getWidth() <= maxTransportableWidth &&
                transportable.getHeight() <= maxTransportableHeight &&
                transportable.getLength() <= maxTransportableLength; }

    public boolean transporterIsNotFull(){ return transporterStorageList.size() < maxStoredObjects; }

    public boolean closeEnough(ITransportable transportable){
        return transportable.getX() >= super.getX()-5 &&
                transportable.getX() <= super.getX()+5 &&
                transportable.getY() >= super.getY()-5 &&
                transportable.getY() <= super.getY()+5;
    }

    public void updateStoredObjectsPosition(){
        for(ITransportable transportable : transporterStorageList){
            transportable.setX(getX());
            transportable.setY(getY());
        }
    }
}
