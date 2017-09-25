package com.hust.bigdataplatform.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import com.hust.bigdataplatform.util.ResultUtil;

public class PermissionInterceptor implements HandlerInterceptor {
	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(PermissionInterceptor.class);

	@Autowired
	private MappingJackson2HttpMessageConverter converter;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
		/*try {
			String url = request.getRequestURI();
			System.out.println("------------------------------------"+url);
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(Constant.UESR);
			System.out.println("------------------------------------user下");
			if ("/".equals(url) || "/index.html".equals(url)) {
				if (null != user) {
					//response.sendRedirect("/topic-list.html");
				} else {
					System.out.println("------------------------------------user=null");
				}
				return true;
			} else {
				System.out.println("------------------------------------else内");
				if (user == null) {
					System.out.println("------------------------------------else if内");
					LOG.warn("session失效，请重新登陆。");
				} else {// 如果session没有失效，判断当前用户是否有访问该资源的权限。
					System.out.println("------------------------------------else else内");
					List<String> powers = (List<String>) session.getAttribute(Constant.USERPOWER);
					String requestPath = request.getServletPath();
					if (powers != null && powers.contains(requestPath)) {
						return true;
					}
					//暂时开放权限
					//fail(response);
					return true;
				}
			}
		} catch (Exception e) {
			LOG.error("permissionInterceptor 错误。 \t" + e.toString());
			try {
				response.sendRedirect("/error.html");
			} catch (Exception e1) {
				LOG.error("跳转发生异常" + e1.toString());
			}
		}
		return false;*/
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	private void fail(HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			converter.write(ResultUtil.errorWithMsg("非常抱歉，您没有权限访问该资源，请联系管理员"), MediaType.APPLICATION_JSON,
					new ServletServerHttpResponse(response));
		} catch (Throwable e) {
			LOG.error("ajax error \t" + e);
		}
	}

}
