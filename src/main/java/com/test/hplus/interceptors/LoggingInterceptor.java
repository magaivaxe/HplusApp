package com.test.hplus.interceptors;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // get all cookies
    // log session id
    // log the resquest path
    final String J_SESSION_ID = "JSESSIONID";
    String sessionId = null;

    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        if (J_SESSION_ID.equals(cookie.getName())) {
          sessionId = cookie.getValue();
        }
      }
    }

    System.out.println("Incoming request data: " + sessionId + "at " + new Date() + "for " + request.getRequestURI());

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
    ModelAndView modelAndView) throws Exception {
    System.out.println("Inside post handle");
  }
}
