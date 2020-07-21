package com.hangyu.platform.aop;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.global.PlatException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

@Aspect
@Component
@Order(2)
public class LogRecordAspect {
//	static Logger logger= LoggerFactory.getLogger(LogRecordAspect.class);
////	@Pointcut("execution(* com.hangyu.platform.web.backBusiness.controller..*.*(..))")
//	@Pointcut("@annotation(com.hangyu.platform.aop.SystemLog)")
//	void logRecordPointcut(){}
//	@Before("logRecordPointcut()")
//	public void doBefore(JoinPoint joinPoint) {
//		StringBuffer sboutput=new StringBuffer();
//		sboutput.append("方法:["+joinPoint.getSignature().getDeclaringTypeName()+
//				"."+joinPoint.getSignature().getName()+"]执行开始");
//		logger.debug(sboutput.toString());
//	}
//    @After("logRecordPointcut()")
//	public void doAfter(JoinPoint joinPoint) {
//    	StringBuffer sboutput=new StringBuffer();
//		sboutput.append("方法:["+joinPoint.getSignature().getDeclaringTypeName()+
//				"."+joinPoint.getSignature().getName()+"]执行完成");
//		logger.debug(sboutput.toString());
//	}
////    @AfterThrowing(pointcut="logRecordPointcut()",throwing="e")
////	public void doThrow(JoinPoint joinPoint,Throwable e) {
////
////	}
//    @Around("logRecordPointcut()")
//    public Object doAround(ProceedingJoinPoint pjp) {
//    	Object result=null;
//		try {
//			result=pjp.proceed();
//		} catch (Throwable e) {
//			StringBuffer params=new StringBuffer();
//	        Object[] args=pjp.getArgs();
//	        for(Object obj :args) {
//	        	//如果参数类型是请求和响应的http，则跳过
//	        	if (obj instanceof HttpServletRequest || obj instanceof HttpServletResponse){
//	        		continue;
//				}
//	        	if(!(obj instanceof MultipartFile)) {
//	        		params.append(JSON.toJSONString(obj)+',');
//	        	}
//	        }
//	    	StringBuffer sboutput=new StringBuffer();
//			sboutput.append("方法:["+pjp.getSignature().getDeclaringTypeName()+
//					"."+pjp.getSignature().getName()+"]执行异常:");
//			sboutput.append("参数--"+params+"\n");
//			final Writer writer = new StringWriter();
//	        final PrintWriter printWriter = new PrintWriter(writer);
//	        e.printStackTrace(printWriter);
//	        sboutput.append(writer.toString());
//			logger.error(sboutput.toString());
//			if(e instanceof PlatException){
//				throw new PlatException(e.getMessage());
//			}else{
//				throw new RuntimeException("服务器内部错误");
//			}
//		}
//		return result;
//
//	}
}
