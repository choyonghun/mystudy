package bitcamp.config;

import javax.servlet.Registration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AdminDispatcherServletInitializer  extends
    AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    // ContextLoaderListener 의 IoC 컨테이너가 사용할 Java Config 클래스를 리턴한다.
    // AppDispatcherServletInitializer 에서 이미 설정했기 때문에
    // 여기서는 null을 리턴한다.
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // DispatcherServlet 의 IoC 컨테이너가 사용할 Java Config 클래스를 리턴한다.
    return new Class<?>[] {AdminConfig.class};
  }
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/admin/*"};
  }

  @Override
  protected String getServletName() {
    return "admin";
  }
}