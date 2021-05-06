package com.mvc.update.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// 1. ApplicationConfig
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(ApplicationConfig.class);
		//ApplicationContext xml의 경로를 읽어서 거기 설정들을 가지고 어쩌구저쩌구 하겠다.
		//어노테이션으로 된  config설정을 웹에서 사용할거다. 
		
		
		// 2. Listener
		servletContext.addListener(new ContextLoaderListener(applicationContext));
		//프로젝트 전체에 사용되어서
		
		// 3. ServletConfig
		AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
		servletConfig.register(ServletConfig.class);
		
		ServletRegistration.Dynamic dispatcherServlet = 
				servletContext.addServlet("dispatcherServlet", new DispatcherServlet(servletConfig));
		//DispatcherServlet: front controller 로 ServletRegistration잡아주는 애
		//서블릿을 등록, 설정, 연결해주는애로 DispatcherServlet을 만들었다.
		
		dispatcherServlet.setLoadOnStartup(1);//setLoadOnStartup: 서블릿이 여러개일때 가장 먼저, 순서 지정해주는 것
		dispatcherServlet.addMapping("*.do");
		
		// 4. encodingFilter
		FilterRegistration.Dynamic filterRegistration = 
				servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true));
		filterRegistration.addMappingForUrlPatterns(null, true, "/*");
		//FilterRegistration 필터 등록할거야
		
		//addMappingForUrlPatterns의 Parameters:
		// 1. dispatcherTypes : 필터 매핑의 디스패처 유형. 기본 DispatcherType.REQUEST가 사용될 경우 null 
        // 2. isMatchAfter :  지정된 필터매핑이 선언된 필터 맵핑 후에 일치해야하는경우 true
        // FilterRegistration을 얻은 ServletContext의 선언된 필터 매핑 전에 일치해야 하는 경우 false
        // 3. urlPatterns : 필터 매핑의 URL 패턴
	}

}
