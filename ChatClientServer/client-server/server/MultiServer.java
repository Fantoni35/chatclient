public class MultiServer{
    public void start(){
        ThreadMap threadMap = new ThreadMap();
   
        try {
    
            ServerSocket serverSocket = new ServerSocket (6789);
    
            for(;;){
    
                Socket socket = serverSocket.accept();
   
                System.out.println("Connessione di" + socket);
    
    ServerThread serverThread = new ServerThread (socket, serverSocket, threadMap);
   
    serverThread.start();
            }
   
        }
        catch (Exception e) {
    system.out.println(e.getMessage());
    System.out.println("Errore durante l'istanza del server !") ;
    System.exit(1);
        }
    }
}