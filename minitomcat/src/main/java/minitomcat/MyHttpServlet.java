package minitomcat;

/**
 * 此类是所有Servlet类的顶级父类
 */
public abstract class MyHttpServlet {
    private static  final  String HTTP_GET = "GET";
    private static  final  String HTTP_POST = "POST";

    public void service(MyHttpServletRequest request,MyHttpServletResponse response){
        if (HTTP_GET.equalsIgnoreCase(request.getMethod())) {
            doGet(request,response);
        }else if(HTTP_POST.equalsIgnoreCase(request.getMethod())) {
            doPost(request,response);
        }else{
            throw new UnsupportedOperationException("other http method is not supported!!! sorry!");
        }
    }

    /**
     * 处理get请求
     */
    public   void doGet(MyHttpServletRequest request,MyHttpServletResponse response){}

    /**
     * 处理post请求
     */
    public    void doPost(MyHttpServletRequest request,MyHttpServletResponse response){}

}
