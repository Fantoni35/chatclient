package client;

import java.io.*;
import java.net.*;

public class Cliente {
    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket miosocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaricevutadalserver;
    DataOutputStream outversoserver;
    BufferedReader indalserver;
    String[] persona;

    public Socket connetti() {
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new Socket(nomeServer, portaServer);

            outversoserver = new DataOutputStream(miosocket.getOutputStream());
            indalserver = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
                                                                                               

            do {
                System.out.println("scrivi il nickname");
                stringaUtente = tastiera.readLine();
                outVersoServer.writeBytes(stringaUtente + '\n');
                stringaricevutadalserver = indalserver.readLine();
                System.out.println(stringaricevutadalserver);
            } while (!stringaricevutadalserver.equals("[Server] : Scelta username completato"));

            comunica();

        } catch (UnknownHostException e) {
            System.err.println("non riconosciuto host");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore con la connessione");
            System.exit(1);

        }
        return miosocket;
    }

    public void comunica() {
        Thread listener = new Thread(new ClientListener(indalserver, miosocket));
        Thread printer = new Thread(new ClientPrinter(outversoserver, tastiera, miosocket));
        listener.start();
        printer.start();
    }
}
