package bitcamp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class App2WebApplicationInitializer extends
    AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    // ContextLoaderListener 의 IoC 컨테이너가 사용할 Java Config 클래스를 리턴한다.
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // DispatcherServlet 의 IoC 컨테이너가 사용할 Java Config 클래스를 리턴한다.
    return new Class<?>[] {App2Config.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app2/*"};
  }

  @Override
  protected String getServletName() {
    return "app2";
  }
}