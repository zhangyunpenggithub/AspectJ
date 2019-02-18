package com.example.aspectj;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * +----------------------------------------------------------------------
 * | 59197696@qq.com
 * +----------------------------------------------------------------------
 * | 功能描述:
 * +----------------------------------------------------------------------
 * | 时　　间: 2019/2/15.
 * +----------------------------------------------------------------------
 * | 代码创建: 张云鹏
 * +----------------------------------------------------------------------
 * | 版本信息: V1.0.0
 * +----------------------------------------------------------------------
 **/
@Aspect
public class AspectTest {

    /**
     * 统计点击耗时
     */
    @Around("execution(* android.view.View.OnClickListener.onClick(..))")
    public void countTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        Log.e("countTime", String.valueOf((end - start)));
    }


    /**
     * 统计Activity各个声明周期耗时
     */
//    @Around("execution(* android.app.Activity+.on**(..))")
    @Around("execution(* *..MainActivity.on**(..))")
    public void method(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        String className = proceedingJoinPoint.getThis().getClass().getSimpleName();


        long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        Log.e("countTime", className + "的" + methodName + "生命周期耗时" + (end - start));
    }
}
