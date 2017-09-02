package com.flower.intellij;

import com.flower.intellij.filter.NoCacheFilter;
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
        bean.addUrlPatterns(new String[]{"/p/*", "/resources/*", "*.jsp"});
        return bean;
    }

    @Bean
	public Filter noCacheFilterBean(){
		return new NoCacheFilter();
	}

    public static void main(String[] args) {
        SpringApplication.run(IntellijApplication.class, args);
    }
}
