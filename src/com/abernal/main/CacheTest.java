package com.abernal.main;

import com.abernal.impl.CacheListenerImpl;
import com.abernal.impl.CacheManagerService;
import com.abernal.impl.CachedObject;
import com.abernal.interfaces.Listener;
import com.abernal.util.Priority;

/**
 * Created by abernal on 1/27/17.
 */
public class CacheTest {
    public static void main(String[] args){
        CachedObject object1 = new CachedObject(new Long(123456), new String("Alejo"), Priority.PRIORITY_0);
        CachedObject object2 = new CachedObject(new Long(123457), new String("Andres"), Priority.PRIORITY_1);
        CachedObject object3 = new CachedObject(new Long(123458), new String("Carmenza"), Priority.PRIORITY_2);

        Listener myListener = new CacheListenerImpl();
        
        CacheManagerService.addListeners(myListener);

        CacheManagerService.put(object1.getIdentifier(), object1);
        CacheManagerService.put(object2.getIdentifier(), object2);
        CacheManagerService.put(object3.getIdentifier(), object3);
        
        
    }
}
