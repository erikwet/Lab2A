package Model;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Oscar Arvidson and Erik Wetter
 */

public class TransportableHolder<T extends ITransportable> implements ITransportableHolder<T> {

    protected Deque<T> transporterStorageList = new ArrayDeque<>();
    private int maxStoredObjects ;
    private double maxTransportableWidth;
    private double maxTransportableHeight;
    private double maxTransportableLength;
    private boolean isLoadingPointOpen;
    protected double x;
    protected double y;

    /**
     *
     * @param maxStoredObjects Number of max allowed stored objects
     * @param maxTransportableWidth Max allowed width of transported object
     * @param maxTransportableHeight Max allowed height of transported object
     * @param maxTransportableLength Max allowed length of transported object
     * @param x X Position in world
     * @param y Y Position in world
     */

    public TransportableHolder(int maxStoredObjects, double maxTransportableWidth, double maxTransportableHeight, double maxTransportableLength, double x, double y) {
        this.maxStoredObjects = maxStoredObjects;
        this.maxTransportableWidth = maxTransportableWidth;
        this.maxTransportableHeight = maxTransportableHeight;
        this.maxTransportableLength = maxTransportableLength;
        this.x = x;
        this.y = y;
    }

    /**
     * Opens the loading point
     */
    public void openLoadingPoint (){
        isLoadingPointOpen = true;
    }

    /**
     * Closes the loading point
     */
    public void closeLoadingPoint(){
        isLoadingPointOpen = false;
    }

    /**
     * Loads a transportable on the transportable holder
     * @param transportable The transportable object being loaded.
     */
    @Override
    public void loadTransportable(T transportable){
        if (transporterIsNotFull() && transportableFits(transportable) && closeEnough(transportable) && isLoadingPointOpen){
            transporterStorageList.add(transportable);
        }
    }

    /**
     * Unloads a transportable off the transportable holder
     */
    @Override
    public void unloadTransportable(){
        if(isLoadingPointOpen) {
            T unloadedTransportable = transporterStorageList.pop();
            unloadedTransportable.setX(getX()+3);
        }
    }

    /**
     * Checks if transportable fits on the transportable holder
     * @param transportable The transportable object being tested.
     * @return True or False if the transportable fits
     */
    @Override
    public boolean transportableFits(T transportable){
        return transportable.getWidthMeter() <= maxTransportableWidth &&
                transportable.getHeightMeter() <= maxTransportableHeight &&
                transportable.getLengthMeter() <= maxTransportableLength;
    }

    /**
     * Check if transporters storage is full
     * @return True or False if it is transporters storage is full
     */
    @Override
    public boolean transporterIsNotFull(){
        return transporterStorageList.size() < maxStoredObjects;
    }

    /**
     * Check if object is close enough to transportable holder to be loaded
     * @param transportable The transportable being checked.
     * @return True or False if transportable is close enough
     */
    @Override
    public boolean closeEnough(T transportable){
        return (transportable.getX() >= x-5 &&
                transportable.getX() <= x+5 &&
                transportable.getY() >= y-5 &&
                transportable.getY() <= y+5);
    }

    /**
     * Updates position of objects in transporters storage with transporters x and y
     * @param x X position of transporter holder
     * @param y Y position of transporter holder
     */
    public void updateStoredObjectsPosition(double x, double y){
        this.x = x;
        this.y = y;
        for(T transportable : transporterStorageList){
            transportable.setX(x);
            transportable.setY(y);
        }

    }

    /**
     * Gets x position for the transporter holder in the world.
     * @return X position of the transporter holder in the world.
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Gets y position for the transporter holder in the world.
     * @return Y position of the transporter holder in the world.
     */
    @Override
    public double getY() {
        return y;
    }
}
