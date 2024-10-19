/*
 * package com.PBL4.test.config;
 * 
 * import java.util.List;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.view.ContentNegotiatingViewResolver; import
 * org.springframework.web.servlet.view.InternalResourceViewResolver; import
 * org.springframework.web.servlet.view.JstlView;
 * 
 * @Configuration public class ThymeleafConfig {
 * 
 * @Bean public ContentNegotiatingViewResolver
 * contentNegotiatingViewResolver(InternalResourceViewResolver
 * internalResourceViewResolver) { ContentNegotiatingViewResolver viewResolver =
 * new ContentNegotiatingViewResolver();
 * viewResolver.setViewResolvers(List.of(internalResourceViewResolver));
 * viewResolver.setOrder(1); return viewResolver; }
 * 
 * @Bean public InternalResourceViewResolver internalResourceViewResolver() {
 * InternalResourceViewResolver viewResolver = new
 * InternalResourceViewResolver(); viewResolver.setViewClass(JstlView.class);
 * viewResolver.setPrefix("/WEB-INF/views/"); viewResolver.setSuffix(".jsp");
 * viewResolver.setOrder(2); return viewResolver; } }
 */