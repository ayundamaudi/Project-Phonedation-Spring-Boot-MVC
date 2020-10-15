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

@Order(3)
public class AdminFilter implements Filter {
  @Autowired
  private HttpSession session;

  Logger log = LoggerFactory.getLogger(SessionFilter.class);

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    if (req.getRequestURI().equals("/admin/dist/img/AdminLTELogo.png")) {
      return;
    }
    log.info(req.getMethod() + " - " + req.getRequestURI());

    session = req.getSession();
    User user = (User) session.getAttribute("USER");
    if (!user.getRole().equals("admin")) {
      res.sendRedirect("/");
      return;
    }
    chain.doFilter(req, res);
  }
}
