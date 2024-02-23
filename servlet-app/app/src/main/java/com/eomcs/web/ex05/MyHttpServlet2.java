package com.eomcs.web.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class MyHttpServlet2 extends GenericServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    // 서블릿 컨테이너가 이 메서드를 호출하면

    // => 파라미터 값을 원래의 타입으로 변환한다.
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    // => 오버로딩한 service()를 호출한다.
    this.service(request, response);
  }

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getMethod().equals("GET")) {
      doGet(request, response);
    } else if (request.getMethod().equals("POST")) {
      doPost(request, response);
    } else {
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("해당 메서드를 지원하지 않습니다.");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("아직 구현하지 않았습니다.");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("아직 구현하지 않았습니다.");
  }


}


