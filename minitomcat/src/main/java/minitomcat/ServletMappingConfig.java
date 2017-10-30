package minitomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类用来模拟web.xml文件中的servlet配置
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappings = new ArrayList<>();

    static {
        servletMappings.add(new ServletMapping("/hello", "hello", "minitomcat.HelloServlet"));
    }

}
