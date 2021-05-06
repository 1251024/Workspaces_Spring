package com.mvc.update.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//xml: Extensible Markup Language- 확장가능한 마크업 랭귀지
//servlet-context.xml

@Configuration
//@Configuration : spring bean Configuration을 대신하고 싶을때 사용
@EnableWebMvc
//@EnableWebMvc: <annotation-driven />, Spring MVC와 관련된 annotation을 사용할 수 있게 함(@Controller, @Service...)
@ComponentScan("com.mvc.update")
//@ComponentScan:context:component-scan 대체하여  base-package 지정
public class ServletConfig implements WebMvcConfigurer {

	//WebMvcConfigurer를 상속받아서 사용
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		//앞에가 mapping, 뒤에가 location
		//<resources mapping="/resources/**" location="/resources/" />
	}
	
	//Resolver 객체 생성
	@Bean
	public InternalResourceViewResolver	getResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
		/*
		<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<beans:property name="prefix" value="/WEB-INF/views/" />
			<beans:property name="suffix" value=".jsp" />
		</beans:bean>
		*/
		
		
	
	}
}
