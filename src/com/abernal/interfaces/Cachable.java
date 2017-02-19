package com.abernal.interfaces;

import com.abernal.util.Priority;

/**
 * Created by abernal on 1/26/17.
 */
public interface Cachable {
    
    Object getValue();
    
    void setValue(Object value);
    
    Priority getPriority();
    
    void setPriority(Priority priority);
    
    Object getIdentifier();
    
    void setIdentifier(Object identifier);
}
