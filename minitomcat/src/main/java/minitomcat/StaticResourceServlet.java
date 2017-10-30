package minitomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 这个servlet用来处理静态资源，在这里的实现中，只读取类路径下的静态资源，没处理目录
 */
public class StaticResourceServlet extends MyHttpServlet{
    @Override
    public void service(MyHttpServletRequest request, MyHttpServletResponse response) {
        String fileName = request.getUrl().substring(1);//剔除掉“/"
        //演示的目的，所以路径写死，并且也没有跨平台处理
        File file = new File("E:\\IdeaProjects\\miniservletContainer\\minitomcat\\src\\main\\resources"+ File.separator + fileName);
        if(file.exists() && file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                String content = new String(bytes, "UTF-8");
                response.write(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
