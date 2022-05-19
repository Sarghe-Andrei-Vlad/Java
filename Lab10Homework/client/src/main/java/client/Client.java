package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static final String serverAddress = "127.0.0.1";
    public static final int PORT = 8100;

    public Client() throws IOException {
        try (
            Socket socket = new Socket(serverAddress, PORT);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            while(true) {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter your command: ");
                String request = scan.nextLine();
                out.println(request);
                out.flush();

                if(request.equals("exit") || request.equals("stop"))
                    break;

                String fullResponse = in.readLine();
                if(fullResponse == null)
                    break;
                System.out.println(fullResponse);
            }

            System.out.println("Bye!");
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (SocketException e){
            System.err.println("You have been disconnected!");
        }
    }
}
