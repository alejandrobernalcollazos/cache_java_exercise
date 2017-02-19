package com.abernal.util;

/**
 * Created by abernal on 1/27/17.
 */
public enum Priority {
    PRIORITY_0(15000), PRIORITY_1(10000), PRIORITY_2(5000);

    private int timeToExpireInMilliSeconds;
    
    Priority(int timeToExpireInMilliSeconds) {
        this.timeToExpireInMilliSeconds = timeToExpireInMilliSeconds;
    }

    public int getTimeToExpireInMilliSeconds() {
        return timeToExpireInMilliSeconds;
    }
}
