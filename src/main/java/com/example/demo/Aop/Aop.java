package com.example.demo.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {

    @Pointcut("execution(* com.example.demo.Dao.data.*(*))")
    public void myPointcut() {}
    @Value("123")
     String str;


    String cp;
    // 前置通知
    @Before("myPointcut()")
    public void beforeAdvice() {
        System.out.println("前置通知：方法调用前执行");
    }

    // 后置通知
    @After("myPointcut()")
    public void afterAdvice() {
        System.out.println("后置通知：方法调用后执行");
    }

    // 返回后通知
    @AfterReturning("myPointcut()")
    public void afterReturningAdvice() {
        System.out.println("返回后通知：方法正常返回后执行");
    }

    // 异常通知
    @AfterThrowing("myPointcut()")
    public void afterThrowingAdvice() {
        System.out.println("异常通知：方法抛出异常时执行");
    }

    // 环绕通知
    @Around("myPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知：前");
        Object result = joinPoint.proceed(); // 调用目标方法
        System.out.println("环绕通知：后");
        return result;
    }
}
