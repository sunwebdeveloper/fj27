package br.com.casadocodigo.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages={"br.com.casadocodigo.loja"})
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/views/");
		view.setSuffix(".jsp");
		
		view.setExposedContextBeanNames("shoppingCart");
		return view;
	}
	
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource message = new ReloadableResourceBundleMessageSource();
		message.setBasename("/WEB-INF/messages");
		message.setCacheSeconds(1);
		message.setDefaultEncoding("UTF-8");
		
		return message;
	}
	
	@Bean
	public FormattingConversionService mvcConversionService(){
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);
		
		DateFormatterRegistrar dateFormatter = new DateFormatterRegistrar();
		dateFormatter.setFormatter(new DateFormatter("yyyy-MM-dd"));
		dateFormatter.registerFormatters(conversionService);
		
		return conversionService;
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}
}
