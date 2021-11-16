import java.io.*;
import java.net.*;
import java.util.*;
public class MultiServer{
    public void start(){
        try{
            ServerSocket serverSocket=new ServerSocket(6789);
        for(;;){
            System.out.println("1 server in attesa");
            Socket socket=serverSocket.accept();
            System.out.println("3Server socket"+ socket);
            ServerThread serverThread= new ServerThread(socket);
            serverThread.start();
        }        
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("errore durante l'istanza del server");
        System.exit(1);
    }
    }



    public static void main(String[]args){
        MultiServer tcpServer= new MultiServer();
        tcpServer.start();
    }
}



