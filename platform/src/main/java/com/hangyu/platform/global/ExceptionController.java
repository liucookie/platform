package com.hangyu.platform.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller异常处理类，所有Controller中未捕获的异常，都会在该类中寻找与异常类型相匹配的方法
 * ExceptionHandler 捕获到类型相匹配的异常，会进入相应的方法
 * 请求通过DispatcherServlet分发，到了doDispatcher()方法阶段，只有异常存在时，才会触发ExceptionHandler，前提是
 * 已经配置了ExceptionHandler处理器。
 * 404请求，不会抛出异常，当URL不存在时，还会HttpRequestHandlerAdapter去加载静态资源，所以不会被ExceptionHandler捕获
 * 该类中不要捕获Exception类型的异常，Exception类型的异常有全局异常处理类FrameworkController来统一处理
 *
 * @author
 * @date
 */
@RestControllerAdvice
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    Result result = new Result(ResultStatusEnum.EXPECTION.getCode(),ResultStatusEnum.EXPECTION.getMessage());

    @ExceptionHandler(PlatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handlerPlatException(PlatException e) {
        logger.error(e.getMessage(), e);
        Result result = new Result(ResultStatusEnum.EXPECTION.getCode(),e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handlerRuntimeException(RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handlerSqlException(SQLException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handlerIOException(IOException e)
    {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handlerException(Exception e)
    {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
