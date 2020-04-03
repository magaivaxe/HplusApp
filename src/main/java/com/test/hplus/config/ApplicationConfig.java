package com.test.hplus.config;

import java.util.Locale;

import com.test.hplus.convertors.StringToEnumConvertor;
import com.test.hplus.interceptors.LoggingInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.test.hplus")
public class ApplicationConfig extends WebMvcConfigurationSupport {

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("css/**", "images/**").addResourceLocations("classpath:/static/css/",
        "classpath:/static/images/");
  }

  @Bean
  public InternalResourceViewResolver jspViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");
    viewResolver.setViewClass(JstlView.class);
    return viewResolver;
  }

  @Override
  protected void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new StringToEnumConvertor());
  }

  /**
   * Async calls configuration.Inside we can use configurer to set mult things as
   * timeout, tasks etc...
   *
   * @param configurer use to set params inside method, as tasks and timeout. See
   *                   doc.
   */
  @Override
  protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    configurer.setDefaultTimeout(8000);
    configurer.setTaskExecutor(mvcTaskExecutor());
  }

  /**
   * tasks configuration. Set the thread's name prefix. Each thread will start
   * with this prefix
   */
  @Bean
  public AsyncTaskExecutor mvcTaskExecutor() {
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setThreadNamePrefix("hplusapp-thread-");
    return threadPoolTaskExecutor;
  }

  /**
   * Intercepts each call to controller and executes methods like wish
   */
  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/*");
    registry.addInterceptor(new ThemeChangeInterceptor());// theme
    registry.addInterceptor(new LocaleChangeInterceptor());// locale
  }

  @Bean
  public ThemeResolver themeResolver() {
    CookieThemeResolver resolver = new CookieThemeResolver();
    resolver.setCookieName("theme");
    resolver.setDefaultThemeName("client-theme-1");
    return resolver;
  }

  @Bean
  public LocaleResolver localeResolver() {
    CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
    cookieLocaleResolver.setDefaultLocale(Locale.US);
    cookieLocaleResolver.setCookieName("locale");
    return cookieLocaleResolver;
  }

}
