package com.hangyu.platform.utils;

import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShiroHelp {
	//与当前session绑定
	private static HttpSession session;
	public static HttpSession getSession() {
		return session;
	}

	public static void setSession(HttpSession s) {
		session = s;
	}
	//绑定设备别名
	private static String alias;

	
	public static String getAlias() {
		return alias;
	}

	public static void setAlias(String alias) {
		ShiroHelp.alias = alias;
	}

	public static BmStaffTbl getCurrentUser() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		if (servletRequestAttributes != null && servletRequestAttributes.getRequest() != null) {
			HttpServletRequest request = servletRequestAttributes.getRequest();
			String token = request.getHeader("token");
			if (!StringKit.checkValueIsEmpty(token)) {
				HttpSession httpSession = SessionStore.getSession(token);
				if (httpSession != null) {
					return (BmStaffTbl) httpSession.getAttribute("user");
				} else {
					return null;
				}
			} else {
				Object object = SecurityUtils.getSubject().getPrincipal();
				BmStaffTbl user = null;
				if (object != null) {
					user = (BmStaffTbl) object;
				}
				return user;
			}
		}else {
			Object object = SecurityUtils.getSubject().getPrincipal();
			BmStaffTbl user = null;
			if (object != null) {
				user = (BmStaffTbl) object;
			}
			return user;
		}
	}

	public static BmStaffTbl getCurrentUser(String token) {
		//过滤空格或者回车
		if (!StringKit.checkValueIsEmpty(token)) {
			HttpSession httpSession = SessionStore.getSession(token);
			if (httpSession != null) {
				return (BmStaffTbl) httpSession.getAttribute("user");
			} else {
				return null;
			}
		} else {
			//获取当前用户
			return getCurrentUser();
		}
	}

	public static String getCurrentUserId() {
		BmStaffTbl user = getCurrentUser();
		if (user == null) {
//			return -1;
		}
		return user.getStaffid();
	}

	public static String getCurrentUserName() {
		BmStaffTbl user = getCurrentUser();
		if (user == null) {
			return "";
		}
		return user.getUsername();
	}


}
