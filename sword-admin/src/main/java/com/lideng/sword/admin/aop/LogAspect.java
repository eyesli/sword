//package com.lideng.sword.admin.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.SQLOutput;
//import java.util.Arrays;
//
//@Aspect
//@Component
//@Slf4j
///**
// *  SpringBoot使用AOP统一处理：Web请求日志
// *  SpringBoot使用AOP统一处理：事务处理
// *  SpringBoot使用AOP统一处理：用户登录拦截
// *  SpringBoot使用AOP统一处理：请求幂等级（防止重复提交）
// *  SpringBoot使用AOP统一处理：统计方法执行时长
// * AOPlog
// * @author lideng
// * @date 2019/10/11
// */
//public class LogAspect {
//
//    private String methodName;
//
//    private long startTime;
//
//    /**
//     * 切点是所有的控制器
//     */
//    @Pointcut("execution(public * com.lideng.sword.admin.controller.*.*(..))")
//    public void printLog() { }
//
//    @Before("printLog()")
//    public void printParam(JoinPoint joinPoint){
//
//        Signature signature = joinPoint.getSignature();
//        /**
//         * 代理的是哪一个方法
//         */
//        log.info("方法："+signature.getName());
//         startTime = System.currentTimeMillis();
//        /**
//         * AOP代理类的名字
//         */
//        log.info("方法所在包:"+signature.getDeclaringTypeName());
//
//        /**
//         * AOP代理类的类（class）信息
//         */
//        signature.getDeclaringType();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        String[] strings = methodSignature.getParameterNames();
//        log.info("参数名："+ Arrays.toString(strings));
//        log.info("参数值ARGS : " + Arrays.toString(joinPoint.getArgs()));
//
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest req = attributes.getRequest();
//
//        methodName=joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
//        // 记录下请求内容
//        log.info("请求URL : " + req.getRequestURL().toString());
//        log.info("HTTP_METHOD : " + req.getMethod());
//        log.info("IP : " + req.getRemoteAddr());
//        log.info("请求的方法 : " +methodName);
//        //可以写一个日志实体和日志service 来保存到数据库
//    }
//
//    /**
//     * 无论目标方法在执行过程中出现一场都会在它之后调用
//     */
//    @After("printLog()")
//    public void doAfter() {
//        long eTime = System.currentTimeMillis() - startTime;
//        log.info("执行 " + methodName + " 耗时为：" + eTime + "ms");
//    }
//
//    /**
//     * 若目标方法出现异常，则不执行
//     * @param ret
//     */
//    @AfterReturning(returning = "ret", pointcut = "printLog()")
//    public void doAfterReturning(Object ret) {
//        // 处理完请求，返回内容
//        log.info("方法的返回值 : " + ret);
//    }
//
//    @AfterThrowing("printLog()")
//    public void throwss(JoinPoint jp){
//        log.info("方法异常时执行.....");
//    }
//
//}