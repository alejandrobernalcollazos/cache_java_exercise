package com.abernal.impl;

import com.abernal.interfaces.Cachable;
import com.abernal.interfaces.Listener;
import com.abernal.threads.ValidityAndRegistryManagerThread;
import com.abernal.util.CacheOperation;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by abernal on 1/26/17.
 */
public class CacheManagerService {
    
    private static Map cacheManager = new Hashtable<>();
    private static final Set<Listener> listeners = new CopyOnWriteArraySet<>();
    
    static {
        try {
          Thread cleaner = new Thread(new ValidityAndRegistryManagerThread());
            cleaner.setPriority(Thread.MIN_PRIORITY);
            cleaner.start();
        } catch (Exception exception) {
            System.out.println("Cache Manager had the exception : " + exception);
        }
    }
    
    public static void addListeners(Listener listener) {
        listeners.add(listener);
    }
    
    public static void removeListeners(Listener listener) {
        listeners.remove(listener);
    }
    
    public static void put(Object key, Cachable value) {
        cacheManager.put(key, value);
        broadcast(CacheOperation.INSERT, value);
    }
    
    public static Object get(String key) {
        Object object = cacheManager.get(key);
        
        if(object == null)
            return null;
        else 
            return object;
    }
    
    public static Cachable remove(String key) {
        Cachable cachable = (Cachable) cacheManager.remove(key);
        broadcast(CacheOperation.REMOVE, cachable);
        if (cachable == null)
            return null;
        else 
            return cachable;
    }
    
    public static void invalidate(){
        cacheManager.clear();
    }
    
    public static Map getCacheManager(){
        return cacheManager;
    }
    
    private static void broadcast(CacheOperation cacheOperation, Cachable cachable) {
        if (cacheOperation == cacheOperation.INSERT)
            listeners.forEach(listener -> listener.insertedElement(cachable));
        else 
            listeners.forEach(listener -> listener.removedElement(cachable));
    }
}
