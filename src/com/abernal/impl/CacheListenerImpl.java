package com.abernal.impl;

import com.abernal.interfaces.Cachable;
import com.abernal.interfaces.Listener;

/**
 * Created by abernal on 1/27/17.
 */
public class CacheListenerImpl implements Listener {
    @Override
    public void insertedElement(Cachable cachable) {
        System.out.println("The element : " + cachable.getIdentifier() + " were inserted in the cache structure");
    }

    @Override
    public void removedElement(Cachable cachable) {
        System.out.println("The element : " + cachable.getIdentifier() + " were removed from the cache structure");
    }
}
