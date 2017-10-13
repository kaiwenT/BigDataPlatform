package com.hust.bigdataplatform.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
/**
 * 存取、删除Session相关方法
 * @author tankai
 *
 */
@Service
public class SessionService {

	/**
	 * 创建session
	 * @param key
	 * @param object
	 * @param request
	 */
	public void setObject(String key, Object object, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		if (sessionid == null) {
			return;
		}
		session.setAttribute(key, object);
		session.setMaxInactiveInterval(7200);
	}
	/**
	 * 获取session
	 * @param key
	 * @param request
	 * @return
	 */
	public Object getObject(String key, HttpServletRequest request) {
		HttpSession session = request.getSession();			
		return session.getAttribute(key);
	}

	/**
	 * 删除session信息
	 * @param key
	 * @param request
	 */
	public void remove(String key, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		if (sessionid == null) {
			return;
		}
		session.removeAttribute(key);
	}

}
