public interface ITransportableHolder {
    void loadTransportable(ITransportable transportable);
    void unloadTransportable();
    boolean transportableFits(ITransportable transportable);
    boolean transporterIsNotFull();
    boolean closeEnough(ITransportable transportable);
}
