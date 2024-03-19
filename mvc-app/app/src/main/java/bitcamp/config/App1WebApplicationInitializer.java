package bitcamp.config;

import java.io.File;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class App1WebApplicationInitializer extends
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
    return new Class<?>[] {App1Config.class};
  }
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app1/*"};
  }

  @Override
  protected String getServletName() {
    return "app1";
  }

  @Override
  protected void customizeRegistration(Dynamic registration) {
    registration.setMultipartConfig(new MultipartConfigElement(
        new File("./temp").getAbsolutePath(),
        1024*1024*10,
        1024*1024*100,
        1024*1024*1));
  }
}