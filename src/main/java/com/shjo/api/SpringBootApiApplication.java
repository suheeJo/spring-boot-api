package com.shjo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.shjo.api.common.filter.RequestFilter;
import com.shjo.api.common.interceptor.AccessApiCheckInterceptor;

@SpringBootApplication
public class SpringBootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new AccessApiCheckInterceptor()).addPathPatterns("/**");
			}
		};
	}
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		// TODO filter 에서는 dao 같은 것을 사용할 수 없기 때문에 DelegatingFilterProxy를 활용 해야 한다.
		/**
			web.xml
			<filter>
	        	<filter-name>apiFilter</filter-name>
				<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	    	</filter>
	    	<filter-mapping>
		        <filter-name>apiFilter</filter-name>
		        <url-pattern>/apitest/*</url-pattern>
		    </filter-mapping>
			
			ApiFilter.java
			@Service("apiFilter")
			public class ApiFilter implements Filter {
				
				@Autowired
				private ApiTestDao apiTestDao;
				...
			}
		 */
		
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new RequestFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addServletNames("requestFilter");
//		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}
}
