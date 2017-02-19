package com.abernal.threads;

import com.abernal.impl.CacheManagerService;
import com.abernal.impl.CachedObject;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by abernal on 1/27/17.
 */
public class ValidityAndRegistryManagerThread implements Runnable {
    
    int milliSecondSleepTime = 5000;
    Calendar calendar ;
    
    @Override
    public void run() {
        try {
            while (true) {
                calendar = Calendar.getInstance();
                System.out.println("Checking : " + calendar.getTime());
                Set keySet = CacheManagerService.getCacheManager().keySet();
                Iterator keys = keySet.iterator();
                while (keys.hasNext()){
                    Object key = keys.next();
                    CachedObject value = (CachedObject) CacheManagerService.getCacheManager().get(key);
                    if(!value.isValid()){
                        calendar = Calendar.getInstance();
                        System.out.println("About to remove element : " + value.getIdentifier() + " on " +
                                calendar.getTime());
                        value.setRegistered(false);
                        System.out.println("Printing the cache : " + CacheManagerService.getCacheManager().toString());
                    }
                }
                Thread.sleep(this.milliSecondSleepTime);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
