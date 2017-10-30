package minitomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjun on 2017/10/30.
 */
public class MyServer {
    private static  final  int port = 6063;
    private Map<String,String> urlServletMappings = new HashMap<>();

    public  void start(){
        System.out.println("server is starting....");
        initServletConfig();
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();

                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                MyHttpServletRequest request = new MyHttpServletRequest(inputStream);
                MyHttpServletResponse response = new MyHttpServletResponse(outputStream);

                handleRequest(request,response);

                clientSocket.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void initServletConfig() {
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappings) {
            urlServletMappings.put(servletMapping.getUrl(), servletMapping.getClassName());
        }
    }

    private  void handleRequest(MyHttpServletRequest request,MyHttpServletResponse response){
        String servletClassName = urlServletMappings.get(request.getUrl());
        try {
            if( request.getUrl().endsWith(".html") || request.getUrl().endsWith(".htm")) {
                new StaticResourceServlet().service(request,response);
            }else {
                Class<MyHttpServlet> servletClass = (Class<MyHttpServlet>) Class.forName(servletClassName);
                MyHttpServlet myHttpServlet = servletClass.newInstance();
                myHttpServlet.service(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
