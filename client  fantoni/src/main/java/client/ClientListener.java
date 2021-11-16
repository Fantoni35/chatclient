package client;

import java.io.*;
import java.net.Socket;

public class ClientListener implements Runnable {
    String stringaricevutadalserver;
    BufferedReader indalserver;
    String[] persona;
    Socket miosocket;

    public ClientListener(BufferedReader indalserver,Socket miosocket){
        this.indalserver = inDalServer;
        this.persona=new String[0];
        this.miosocket=miosocket;
    }

    public void run() {
        while (!miosocket.isClosed()) {
            try {
                stringaricevutadalserver = indalserver.readLine();
                if (stringaricevutadalserver.indexOf("*") == 0) {
                    persona = stringaricevutadalserver.split(";");
                    for (int i = 0; i < persona.length; i++) {
                        System.out.println(persona[i]);
                    }
                }else{System.out.println(stringaricevutadalserver);}
            }catch (Exception e) {
                System.out.println("Hai lasciato la chat");
                System.exit(1);
            }
        }
    }
}