package com.hangyu.platform.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Java web token 工具类
 *
 * @author
 * @date
 */
public class TokenUtils {

    @Resource
    private BmStaffTblMapper staffMapper;

    /**
     * 过期时间24 hours
     *
     */
    private static final long EXPIRE_TIME = 60 * 60 * 60 * 1000;
    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = CommonFields.getToken();

    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("loginName").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取登陆用户ID
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,15min后过期
     * 生成token
     * @param account 用户名
     * @return 加密的token
     */
    public static String sign(String account,String userId,String userName) {
        try {
             //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
             //私钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            // 附带username，userId信息，生成签名
            return JWT.create()
                    .withHeader(header)
                    .withClaim("loginName", account)
                    .withClaim("userId",userId)
                    .withClaim("userName",userName)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }


    public static String getCurrentId() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (servletRequestAttributes != null && servletRequestAttributes.getRequest() != null) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            String token = request.getHeader("token");
            String userid = getUserId(token);
            return userid;
        }
        return null;
    }

    /**
     * 用户账号
     * @return
     */
    public static String getAccount() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (servletRequestAttributes != null && servletRequestAttributes.getRequest() != null) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            String token = request.getHeader("token");
            String account = getUsername(token);
            return account;
        }
        return null;
    }

    /**
     * 用户名称
     * @return
     */
    public static String getUserName() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (servletRequestAttributes != null && servletRequestAttributes.getRequest() != null) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            String token = request.getHeader("token");
            try {
                DecodedJWT jwt = JWT.decode(token);
                return jwt.getClaim("userName").asString();
            } catch (JWTDecodeException e) {
                return null;
            }
        }
        return null;
    }
}
