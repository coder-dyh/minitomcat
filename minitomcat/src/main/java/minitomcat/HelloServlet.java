package minitomcat;



/**
 * 自己创建的一个Hello World演示用Servlet
 */
public class HelloServlet extends MyHttpServlet {
    @Override
    public void doGet(MyHttpServletRequest request, MyHttpServletResponse response) {
        System.out.println("我在处理get请求");

        response.write("from hello servlet");
    }
}
