package httpServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
public class Socket  implements Runnable
{
    private java.net.Socket clientSocket;

    Socket(java.net.Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    public void run()
    {
        try {
            String response = "";
            InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream outputStream = clientSocket.getOutputStream();
            byte[] data = response.getBytes();
            String resp ="";
            while (bufferedReader.readLine() !=null)
            {
                resp = bufferedReader.readLine();
            }
            System.out.println(resp);
            outputStream.write(data);
            outputStream.flush();
        }catch (IOException ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }
}
