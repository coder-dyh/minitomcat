package minitomcat;

/**
 * 这个类用来描述一个Servlet信息，包含名字、 请求url，以及对应的类名
 */
public class ServletMapping {
    private String url ;
    private String name;
    private  String className;

    public ServletMapping() {
    }

    public ServletMapping(String url, String name, String className) {
        this.url = url;
        this.name = name;
        this.className = className;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
