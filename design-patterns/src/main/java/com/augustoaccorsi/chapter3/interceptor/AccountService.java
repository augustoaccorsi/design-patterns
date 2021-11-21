package com.augustoaccorsi.chapter3.interceptor;

import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

@Interceptors(LoggerInterceptor.class)
public class AccountService {

    public AccountService() {
    }

    public void upgradeAccount(String accountNumber){
        //write code
    }

    @ExcludeClassInterceptors
    public void auditAccount(String accountNumber){
        //write code
    }
}
