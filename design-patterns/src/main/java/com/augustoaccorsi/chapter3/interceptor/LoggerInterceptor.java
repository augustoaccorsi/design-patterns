package com.augustoaccorsi.chapter3.interceptor;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Interceptor
@Transactional
public class LoggerInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    private Object doMethodLogging(InvocationContext ic) throws Exception {
        List<String> params = Stream.of(ic.getParameters()).map(Object::toString).collect(Collectors.toList());

        logger.info("Method: "+ic.getMethod().getName()+" called with parameters "+params);

        return ic.proceed();
    }

    @AroundConstruct
    private void doClassLogging(InvocationContext ic) throws Exception {
        long start = System.currentTimeMillis();
        ic.proceed();
        long end = System.currentTimeMillis();

        logger.info("Execution Time: "+(end-start));
    }
}
