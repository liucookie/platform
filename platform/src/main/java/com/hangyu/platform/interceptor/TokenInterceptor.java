package com.hangyu.platform.interceptor;

import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.TokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义token拦截器
 *
 * @author  liuxuan
 * @date
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        //token不存在
        if (null != token) {
            //验证token是否正确
            boolean result = TokenUtils.verify(token);
            if (result) {
                return true;
            }else {
                throw new PlatException(ResultStatusEnum.AUTH__TOKEN_ERROR.getCode(),ResultStatusEnum.AUTH__TOKEN_ERROR.getMessage());
            }
        }
        throw new PlatException(ResultStatusEnum.AUTH_TOKEN_NULL.getCode(),ResultStatusEnum.AUTH_TOKEN_NULL.getMessage());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
