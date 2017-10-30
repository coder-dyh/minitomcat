package minitomcat;


import java.io.IOException;
import java.io.InputStream;

/**
 *
 * 表示Http请求的类
 */
public class MyHttpServletRequest  {

    private InputStream inputStream;
    private String url;
    private  String method;



    public  MyHttpServletRequest(InputStream inputStream) {
        this.inputStream = inputStream;
        //下面的代码只是简单的处理了HTTP协议中的请求行数据（也就是第一行的数据）
        //并且只是固定最多读取1024个字节的数据，http协议中传输过来的数据可能不止1024个字节
        // *（只是演示，并不是严格意义上的http协议的解析）*
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        try {
            if((length = inputStream.read(httpRequestBytes)) > 0){
                httpRequest = new String(httpRequestBytes,0,length);
            }
            //第一行的数据可能是这样的"GET /hello "
            String httpRequestLine = httpRequest.split("\n")[0];//第一行
            method = httpRequestLine.split("\\s")[0]; //以空格分割
            url = httpRequestLine.split("\\s")[1]; //以空格分割

            System.out.println("-----" + this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "MyHttpServletRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
