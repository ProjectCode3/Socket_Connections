import java.net.*;
import java.io.*;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public Client(String Address, int port){
       try{
           socket = new Socket(Address, port);
           System.out.println("Connected");
           System.out.println("Enter A Name");
           input = new DataInputStream(System.in);
           out = new DataOutputStream(socket.getOutputStream());
       } catch(UnknownHostException e){
           System.out.println(e);
       } catch(IOException ie){
           System.out.println(ie);
       }
       String line = "";
       while (!line.equals("Over")){
           try{
               line = input.readLine();
               out.writeUTF(line);
           }catch (IOException i){
               System.out.println(i);
           }
       }
       try{
           input.close();
           out.close();
           socket.close();
       } catch(IOException i){
           System.out.println(i);
       }
    }

    public static void main(String[] args){
        Client client = new Client("127.0.0.1", 1100);
    }
}
