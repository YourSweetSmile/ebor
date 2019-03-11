package com.example.ebor.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.ebor.security.UserContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 系统工具类
 * 
 * @author yinjunwu
 *
 */
@Component
public class SysUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;


	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	// 通过name获取Bean.
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	// 通过class获取Bean.
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	// 通过name,class获取指定的Bean
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {


	}
}
