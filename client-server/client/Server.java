import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
    ServerSocket server;
    Socket client;
String stringaRicevuta;
String stringaModificata;
BufferedReader inDalClient;
DataOutputStream outVersoClient;

public Socket attendi(){
    try
    {
        System.out.println("1 server partito in esecuzione");   //creo un server sulla porta 6789
        server=new ServerSocket(6789);                          //rimane in attesa di un client
        client=server.accept();                                 //chiudo il server
        server.close();
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient=new DataOutputStream(client.getOutputStream());
        
        
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("errore durante l'istanza del server!");
        System.exit(1);
    }
    return client;
}
 public void comunica()
 {
     try
     {
         System.out.println("3 benvenuto client,scrivi una frase e la trasformo in maiuscolo ,Attendo");
         stringaRicevuta=inDalClient.readLine();
         System.out.println("6 ricevuta la stringa del cliente:"+stringaRicevuta);
         stringaModificata=stringaRicevuta.toUpperCase();
         System.out.println("7 invio la stringa modificata al client");
         outVersoClient.writeBytes(stringaModificata+'\n');
         System.out.println("9 server: fine elaborazioine ... buona notte");
         client.close();
         
     }
     catch(Exception e){

     }
    
    



 

 }
    
    public static void main(String[] args) {
        Server servente= new Server();
        servente.attendi();
        servente.comunica();
    }
}    
