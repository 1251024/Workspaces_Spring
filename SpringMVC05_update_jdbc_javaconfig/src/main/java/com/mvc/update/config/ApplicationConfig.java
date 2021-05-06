package com.mvc.update.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
//@Configuration: 설정 파일입니다. (applicationcontext.xml파일도 spring bean configration파일로 만들었음)
@PropertySource("classpath:sqls/db.properties")
//@PropertySource: property-placeholder설정
public class ApplicationConfig {

	@Value("${oracle.driver}")
	private String driver;
	
	@Value("${oracle.url}")
	private String url;
	
	@Value("${oracle.username}") 
	private String username;
	
	@Value("${oracle.password}") 
	private String password;
	
	/*
	@Value("${oracle.driver}") private String driver;
	@Value("{oracle.url}") private String url;
	@Value("${oracle.username}") private String username;
	@Value("${oracle.password}") private String password;
	*/
	
	
	
	//dataSource객체 생성
	//bean으로 등록된 애는 @Bean으로 등록할 수 있다.
	//DriverManagerDataSource객체가 리턴되게 지정
	//property 지정
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	//jdbcTemplate 객체 생성
	//dataSource객체 참조해서 setDataSource로해서 jdbcTemplate넣어주겠다. 
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		return jdbcTemplate;
	}
	
	
}
