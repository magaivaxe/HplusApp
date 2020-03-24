package com.test.hplus.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // get all cookies
    // log session id
    //
    String sessionId = null;
    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        if ("JSESSIONID".equals(cookie.getName())) {
          sessionId = cookie.getValue();
        }
      }
    }
    return true;
  }
}
