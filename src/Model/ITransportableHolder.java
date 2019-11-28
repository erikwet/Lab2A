package Model;

/**
 * @author Oscar Arvidson and Erik Wetter
 * Interface for all objects that can hold a transportable object that extends the interface Model.IPositionable.
 */
public interface ITransportableHolder<T> extends IPositionable {

    /**
     * Loads a transportable object on/in a transportableHolder.
     * @param transportable The transportable object being loaded.
     */
    void loadTransportable(T transportable);

    /**
     * Unloads a transportable object in the same order it was loaded.
     */
    void unloadTransportable();

    /**
     * Checks if a transportable object fits in a transportableHolder.
     * @param transportable The transportable object being tested.
     * @return True or False depending on if the transportable fits in/on the transportableHolder or not.
     */
    boolean transportableFits(T transportable);

    /**
     * Checks if a transportableHolder have space for more transportable objects.
     * @return True or False depending on if the transportableHolder has space for more or not.
     */
    boolean transporterIsNotFull();

    /**
     * Checks if a transportable is close enough to be loaded on to a transportableHolder.
     * @param transportable The transportable being checked.
     * @return True or False depending on if the transportable is close enough to the transportableHolder or not.
     */
    boolean closeEnough(T transportable);
}
