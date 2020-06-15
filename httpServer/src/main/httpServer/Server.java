package httpServer;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
class Server implements Runnable
{
    private static final int port = 9090;
    public void run(){
        System.out.println("Server is starting on ...  "+port+" ");
        try
        {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(20);
            HttpServer server =  HttpServer.create(new InetSocketAddress("localhost",9090),0);
            server.createContext("/", new RootHandler());
            server.createContext("/post",new Handler());
            server.setExecutor(threadPoolExecutor);
            server.start();
        }catch (IOException ex)
        {
            ex.getStackTrace();
            ex.printStackTrace();
        }
    }
}