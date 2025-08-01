package com.example.demo.Aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)//多个表达式匹配上时的执行顺序
public class Aop {
    //表达式
    @Pointcut("execution(* com.example.demo.Sever.sever.*(*))")
    private void myPointcut() {}
    //自定义注解
    @Pointcut("@annotation(com.example.demo.Aop.MyAnnotation)")
    private  void myPointcut2(){};
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
    @AfterReturning(value = "myPointcut()",returning = "ret")
    public void afterReturningAdvice(String ret) {
        System.out.println("返回后通知：方法正常返回后执行"+ret);
    }

    // 异常通知
    @AfterThrowing(value = "myPointcut()",throwing = "ret")
    public void afterThrowingAdvice(Throwable ret) {
        System.out.println("异常通知：方法抛出异常时执行"+ret);
    }

    // 环绕通知
    @Around("myPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知：前");
        long start  =System.currentTimeMillis();
        Object result = joinPoint.proceed(); // 调用目标方法
        String s=JSONObject.toJSONString(result);//方法返回值
        Object [] args=joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        /*
        * int n=args.length;
        * int i;
        *for(i=0;i<n;i++)
        * args 参数预处理
        * joinPoint.proceed(args);
        * */
        long end=System.currentTimeMillis();
        System.out.println("环绕通知：耗费时间"+(end-start)+"millis");
        return result;
    }
}
