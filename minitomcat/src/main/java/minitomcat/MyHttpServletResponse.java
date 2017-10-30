package minitomcat;


import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author chenjun
 * @date 2017/10/30
 */
public class MyHttpServletResponse  {

    private OutputStream outputStream ;

    public  MyHttpServletResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public  void write(String content)  {

        StringBuffer responseContent = new StringBuffer();
        responseContent.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append(content);
        try {
            outputStream.write(responseContent.toString().getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
