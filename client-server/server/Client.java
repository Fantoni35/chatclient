
import java.io.*;
import java.net.*;




public class Client {
    String nomeServer="Localhost";      //indirizzo server locale
    int portaServer=6789;               // porta x servizio data e ora
    Socket mioSocket;
    BufferedReader tastiera;            //buffer per input da tastiera
    String stringaUtente;               //stringa inserita dall'utente
    String stringaRicevutaDalServer;    // stringa ricevuta dal server
    DataOutputStream outVersoServer;    //stream di output
    BufferedReader inDalServer;         //stream di input

    public Socket Connetti(){
        System.out.println("Client partito in esecuzione");
        try
        {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mioSocket=new Socket(nomeServer,portaServer);

            //associo due oggetti al socket per effettuare la scrittura e la lettura


            outVersoServer=new DataOutputStream(mioSocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));

        }
        catch (UnknownHostException e){
            System.err.println("host sconosciuto");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore durante la connessione!");
            System.exit(1);

        }
        return mioSocket;
    }
    public void comunica(){
        for(;;)
        try{        //leggo una riga
            System.out.println("4... inserisci la stringa da trasmettere al server:"+'\n');
            stringaUtente= tastiera.readLine();
                    // la spedisco al server
            System.out.println("5...invio la stringa al server e attendo...");
            outVersoServer.writeBytes(stringaUtente+'\n');
                    //leggo la risposta del server

            stringaRicevutaDalServer=inDalServer.readLine();
            System.out.println("7...risposta dal server"+'\n'+stringaRicevutaDalServer);
                    //chiudo la connessione
            System.out.println("8 CLIENT: termina elaborazione e chiude la connessione");
            mioSocket.close();
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server");
            System.exit(1);
        }
    }
    public Socket connetti(){
        System.out.println("2 client partito in esecuzione");
        try{

            tastiera=new BufferedReader(new InputStreamReader(System.in));
            mioSocket=new Socket(nomeServer,portaServer);
            outVersoServer=new DataOutputStream(mioSocket.getOutputStream());
            inDalServer= new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));

        }
        catch(UnknownHostException e ){
            System.err.println("Host conosciuto");}
            catch(Exception e){
                System.out.println(e.getMessage());  
                System.out.println("errore durante la connessione");
                System.exit(1);
            }
            return mioSocket;
        }

    




    
    public static void main(String[] args) {
        Client cliente= new Client();
        cliente.Connetti();
        cliente.comunica();
        
    }
} 
