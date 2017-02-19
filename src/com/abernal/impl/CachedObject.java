package com.abernal.impl;

import com.abernal.interfaces.Cachable;
import com.abernal.interfaces.Validable;
import com.abernal.util.Priority;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by abernal on 1/27/17.
 */
public class CachedObject implements Cachable, Validable {
    
    private Date dateOfExpiration;
    private Object identifier;
    private Object value;
    private Priority priority;
    private boolean registered;
    private boolean validity;
    
    public CachedObject (Object identifier, Object value, Priority priority) {
        this.value = value;
        this.priority = priority;
        this.identifier = identifier;
        // Calculate dateOfExpiration
        dateOfExpiration = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfExpiration);
        calendar.add(calendar.MILLISECOND, priority.getTimeToExpireInMilliSeconds());
        dateOfExpiration = calendar.getTime();
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Object getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(Object identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean isRegistered() {
        return registered;
    }

    @Override
    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    @Override
    public boolean isValid() {
        
        Date currentTime = new Date();
        
        if(currentTime.before(dateOfExpiration))
            validity = true;
        else 
            validity = false;
        
        return validity;
    }
    
}
