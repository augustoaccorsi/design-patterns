package com.augustoaccorsi.chapter2.singleton;

import javax.inject.Inject;

public class UsePoolManager {
    @Inject
    private PoolManager poolManager;

    public void usePoolManager(){
        Object object = poolManager.borrowObject();
        // execute code here......
        poolManager.returnObject(object);
    }
}
