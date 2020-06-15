package httpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.*;
public class  Handler   implements HttpHandler,Runnable
{
    public void run(){
    }
    @Override
    public void handle(HttpExchange exchange)
    {
        try {
            String response = "<h3> Http server handler for GET and POST  </h3>";
            exchange.sendResponseHeaders(200,response.length());
            if (exchange.getRequestMethod().equalsIgnoreCase("GET")){
                String getResponse = "GET request has been called by client";
                exchange.sendResponseHeaders(200,getResponse.length());
                OutputStream outputStream  = exchange.getResponseBody();
                outputStream.write(getResponse.getBytes());
                outputStream.close();
            }
            if(exchange.getRequestMethod().equalsIgnoreCase("POST"))
            {
                int sum = 0;
                String parmValue = exchange.getRequestURI().getPath();
                InputStreamReader streamReader = new InputStreamReader(exchange.getRequestBody());
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                String body = bufferedReader.readLine();
                OutputStream outputStream = exchange.getResponseBody();
                String bodyResponse = "sum is  : "+sum+"  ";
                byte[] _data = bodyResponse.getBytes();

                while (!body.matches("end"))
                {
                    try {
                        //Thread.sleep(1000);
                        Integer number = Integer.parseInt(body);
                        sum = sum+number;

                    }catch (Exception ex){
                        ex.getCause();
                        ex.printStackTrace();
                    }
                }
                outputStream.write(_data);
                if(!parmValue.matches("/post"))
                {
                    String customResponse = "no url";
                    OutputStream customeOut = exchange.getResponseBody();
                    customeOut.write(customResponse.getBytes());
                }
                exchange.close();
            }

        }catch(IOException ex)
        {
            System.out.println("Error has been occurred ! ");
            ex.getStackTrace();
            ex.printStackTrace();
            ex.getCause();

        }
    }
}
