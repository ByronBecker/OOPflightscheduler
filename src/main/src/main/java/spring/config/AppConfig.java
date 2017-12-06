package spring.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "spring") //identifies base package structure where cod resigns
public class AppConfig extends WebMvcConfigurerAdapter
{
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");	//where views are located
		viewResolver.setSuffix(".jsp");	//make views be .jsp files
		
		return viewResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(
		DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
}
