package httpServer;
import java.net.ServerSocket;
public class MainClass
{
    private final  static  int  port = 9090;
    private  static  ServerSocket serverSocket;
    private  static httpServer.Socket clientSocket;
    public static  void main(String[] args) throws Exception
    {

        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();


        /*serverSocket = new ServerSocket(port);
        while (true)
        {
            try {
                clientSocket = new httpServer.Socket(serverSocket.accept());
                Thread thread = new Thread(clientSocket);
                thread.start();
            }catch (Exception ex)
            {
                ex.printStackTrace();
                ex.getCause();
            }
        }*/
    }
}
