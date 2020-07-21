package com.hangyu.platform.aop;

import com.hangyu.platform.utils.HyIpAddressTools;
import com.hangyu.platform.utils.TokenUtils;
import com.hangyu.platform.web.logAdmin.dto.Loginfo;
import com.hangyu.platform.web.logAdmin.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


@Aspect
@Component
@Order(3)
public class LogInfoAspect {
    @Autowired
    private LogService logservice;

    //配置接入点,以controller方法为切入点
//    @Pointcut("execution(* com.hangyu.platform.web.backBusiness.controller..*.*(..))")
    @Pointcut("@annotation(com.hangyu.platform.aop.SystemLog)")
    private void controllerAspect() {
    }//定义一个切入点

    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //常见日志实体对象
        Loginfo log = new Loginfo();
        //获取登录用户账户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //获取系统ip,这里用的是我自己的工具类,可自行网上查询获取ip方法
        String ip = HyIpAddressTools.getIpAddr(request);
        log.setIp(ip);

        // 拦截的实体类，就是当前正在执行的controller
        Object target = pjp.getTarget();
        // 拦截的方法名称。当前正在执行的方法
        String methodName = pjp.getSignature().getName();

        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();

        Object object = null;
        // 获得被拦截的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (SecurityException e1) {
            e1.printStackTrace();
        }
        if (null != method) {
            // 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
            if (method.isAnnotationPresent(SystemLog.class)) {
                SystemLog systemlog = method.getAnnotation(SystemLog.class);
                log.setModule(systemlog.module());
                log.setOperateaction(systemlog.methods());
                //用户账号
                String account = TokenUtils.getAccount();
                log.setStaffaccoutname(account);
                //用户真实名称
                String userName = TokenUtils.getUserName();
                log.setUsername(userName);
                try {
                    object = pjp.proceed();
                    log.setStatus("执行成功");
                    //保存进数据库
                    logservice.addLog(log);
                } catch (Throwable e) {
                    log.setStatus("执行失败");
                    logservice.addLog(log);
                    throw e;
                }
            } else
                object = pjp.proceed();
        } else { //不需要拦截直接执行
            object = pjp.proceed();
        }
        return object;
    }
}
