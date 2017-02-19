package com.abernal.interfaces;

/**
 * Created by abernal on 1/27/17.
 */
public interface Listener {
    void insertedElement(Cachable cachable);
    void removedElement(Cachable cachable);
}
