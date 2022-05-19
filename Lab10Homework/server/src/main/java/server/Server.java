package server;

import network.SocialNetwork;
import network.svgExport.SVGExport;
import thread.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8100;
    public static volatile boolean serverRunning = true;

    public Server() throws IOException{
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while(serverRunning){
                System.out.println("Waiting for new connections");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e){
            System.err.println("Error: " + e);
        } finally {
            SocialNetwork socialNetwork = SocialNetwork.getInstance();
            SVGExport svgExport = new SVGExport(socialNetwork.getSocialNetworkUsers());
            svgExport.export();
            serverSocket.close();
        }
    }
}
