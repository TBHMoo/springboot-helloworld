//package org.spring.springboot.aop;
//
//import org.apache.log4j.Logger;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
//* Created by bl05954 on 2017/3/30.
//*/
//
//@Aspect
//@Component
//public class LogAspect {
//    Logger logger = Logger.getLogger(getClass().toString());
//
//    @Pointcut("@annotation(org.spring.springboot.aop.Tag)")
//    public void log(){}
//
//    @Around("log()")
//    public Object around(ProceedingJoinPoint pjp) throws  Throwable{
//        //接收到请求， 记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request  = attributes.getRequest();
//
//        before();
//        logger.info("URL          : " +  request.getRequestURL().toString());
//        logger.info("HTTP_METHOD  : " + request.getMethod());
//        logger.info("IP           : " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
//        logger.info("ARGS         : " +  Arrays.toString(pjp.getArgs()));
//        Object result = pjp.proceed();
//        //after();
//        return result;
//    }
//
//    private void before(){
//        System.out.printf("Before");
//    }
//}
