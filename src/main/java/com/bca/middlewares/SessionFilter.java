package com.bca.middlewares;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bca.entities.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;

// @Component
@Order(1)
public class SessionFilter implements Filter {
  @Autowired
  private HttpSession session;

  Logger log = LoggerFactory.getLogger(SessionFilter.class);

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    session = req.getSession();
    User user = (User) session.getAttribute("USER");
    if (user == null) {
      res.sendRedirect("/login");
      return;
    }
    log.info(user.getFullname() + " - " + req.getMethod() + " - " + req.getRequestURI());
    chain.doFilter(req, res);
  }
}
