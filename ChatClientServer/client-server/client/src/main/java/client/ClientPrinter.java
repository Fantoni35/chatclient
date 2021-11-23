package client;

import java.io.*;
import java.net.Socket;

public class ClientPrinter implements Runnable {
    DataOutputStream outversoserver;
    BufferedReader tastiera;
    String stringaUtente;
    Socket miosocket;
    
    public ClientPrinter(DataOutputStream outversoserver,BufferedReader tastiera, Socket miosocket)  {
        this.outversoserver = outversoserver;
        this.tastiera=tastiera;
        this.miosocket=miosocket;
    }

    public void run() {

        while (miosocket.isConnected()==true) {
            try {
                stringaUtente = tastiera.readLine();
                if( stringaUtente.indexOf("N")==0)//nascosto
                {
                    
                    outversoserver.writeBytes(stringaUtente + '\n');
                }
                   else if( stringaUtente.indexOf("M")==0)//mondiale
                {
                    outversoserver.writeBytes(stringaUtente + '\n');
                }
                if(stringaUtente.equals("ESCO"+'\n'))
                {
                    outversoserver.writeBytes(stringaUtente + '\n');
                    miosocket.close();
                }else{
                    System.out.println("Errore"+'\n');
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Errore durante la comunicazione con il server!"+'\n');
                System.exit(1);
            }
        }
    }
}