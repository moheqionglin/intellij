package com.flower.intellij;

import com.flower.intellij.filter.NoCacheFilter;
import com.tuya.smart.TuyaCloudClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.Filter;

@SpringBootApplication
@EnableConfigurationProperties
public class IntellijApplication extends WebMvcConfigurerAdapter {
    //setting View resolver
	private static final String END_URI = "https://a1.tuyacn.com/api.json";// 调用中国区的API（您可换成其他可用区）

	@Value("${t.a.i}")
	private String accessId;
	@Value("${t.a.k}")
	private String accessKey;

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/app/**").addResourceLocations("/app/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
        registry.addResourceHandler("/components/**").addResourceLocations("/components/");
        registry.addResourceHandler("/bower_components/**").addResourceLocations("/bower_components/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public FilterRegistrationBean noCacheFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(noCacheFilterBean());
        bean.setOrder(110);
        bean.addUrlPatterns(new String[]{"*.jsp"});
        return bean;
    }

    @Bean
	public Filter noCacheFilterBean(){
		return new NoCacheFilter();
	}

	@Bean
	public TuyaCloudClient tuyaCloudClient(){
		return new TuyaCloudClient(accessId, accessKey, END_URI);
	}

    public static void main(String[] args) {
        SpringApplication.run(IntellijApplication.class, args);
    }
}
