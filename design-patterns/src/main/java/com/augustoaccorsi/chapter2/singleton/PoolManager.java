package com.augustoaccorsi.chapter2.singleton;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.ejb.*;

@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@DependsOn("Configuration")
@Startup
@Singleton
public class PoolManager {

    private Queue<Object> pooledObjects;

    @PostConstruct
    void constructExpensiveObjects(){
        pooledObjects = new LinkedBlockingQueue<>(1_000);
        for(int i = 0; i < 1_000; i++){
            pooledObjects.offer(new Object());
        }
    }

    @AccessTimeout(value = 30, unit = TimeUnit.SECONDS)
    @Lock(LockType.WRITE)
    public void returnObject(Object object){
        pooledObjects.offer(object);
    }

    @Lock(LockType.READ)
    public Object borrowObject(){
        return pooledObjects.poll();
    }
}
