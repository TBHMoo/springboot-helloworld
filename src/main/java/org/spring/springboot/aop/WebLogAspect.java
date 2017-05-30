package org.spring.springboot.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by xli on 2017/3/30.
 */

@Aspect
@Component
public class WebLogAspect {

    Logger logger = Logger.getLogger(getClass().toString());

    @Pointcut("@annotation(org.spring.springboot.aop.Tag)")
    public void weblog(){}

    @Around("weblog()")
    public Object around(ProceedingJoinPoint pjp) throws  Throwable{
        ThreadLocal<Long> beginTime = new ThreadLocal<Long>();
        beginTime.set(System.currentTimeMillis());
//        before();
        Object rlt=  pjp.proceed();

        System.out.printf("Spend time :" +  (System.currentTimeMillis() - beginTime.get()));
        return rlt;
    }

    private void before(){
        System.out.println("\n before");
    }
}
