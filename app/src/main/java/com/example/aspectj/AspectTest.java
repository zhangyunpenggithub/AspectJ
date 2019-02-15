package com.example.aspectj;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

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
    @Around("call(com.example.aspectj.MainActivity.initClickListener(..))")
    public void method(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        Log.e("zhangyunpeng", String.valueOf((end - start)));
    }
}
