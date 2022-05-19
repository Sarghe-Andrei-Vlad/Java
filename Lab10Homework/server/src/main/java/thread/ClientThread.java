package thread;

import network.SocialNetworkCommands;
import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientThread extends Thread{
    private Socket socket = null;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            socket.setSoTimeout(60 * 1000);

            String userLoggedIn = "";
            while(Server.serverRunning) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                String request = in.readLine();

                if(request.equals("stop")){
                    Server.serverRunning = false;
                    break;
                }
                if(request.equals("exit"))
                    break;

                SocialNetworkCommands socialNetworkCommands = new SocialNetworkCommands();
                String[] getRequestType = request.split(" ");

                StringBuilder answer = new StringBuilder("");
                switch (getRequestType[0]){
                    case "register":
                        if(userLoggedIn.equals("")) {
                            if (getRequestType.length > 1) {
                                if(socialNetworkCommands.register(getRequestType[1]))
                                    answer.append("Registration has been completed!");
                                else
                                    answer.append("This user already exists!");
                            }
                            else {
                                answer.append("Please type a username!");
                            }
                        }
                        else {
                            answer.append("You cannot register new users while you are logged in!");
                        }
                        break;
                    case "delete":
                        if(userLoggedIn.equals("")) {
                            if (getRequestType.length > 1) {
                                if(socialNetworkCommands.delete(getRequestType[1])){
                                    answer.append("User was successfully deleted!");
                                }
                                else
                                    answer.append("The user does not exists!");
                            }
                            else
                                answer.append("Please type a username!");
                        }
                        else {
                            answer.append("You cannot delete an user while you are logged in!");
                        }
                        break;
                    case "login":
                        if(userLoggedIn.equals("")) {
                            if (getRequestType.length > 1) {
                                if(socialNetworkCommands.login(getRequestType[1])) {
                                    answer.append("You are successfully logged in! Welcome back!");
                                    userLoggedIn = getRequestType[1];
                                }
                                else
                                    answer.append("The person is not registered!");
                            }
                            else {
                                answer.append("Please type a username!");
                            }
                        }
                        else {
                            answer.append("You are already logged in with username: ").append(userLoggedIn);
                        }
                        break;
                    case "logout":
                        if(!userLoggedIn.equals("")){
                            if (getRequestType.length == 1) {
                                answer.append("Bye ").append(userLoggedIn).append("!");
                                userLoggedIn = "";
                            }
                            else
                                answer.append("Wrong 'logout' command!");
                        }
                        else {
                            answer.append("You are not logged in!");
                        }
                        break;
                    case "friend":
                        if(!userLoggedIn.equals("")){
                            if(getRequestType.length > 1) {
                                boolean ok = true;
                                for(int index = 1; index < getRequestType.length; index++){
                                    if(!socialNetworkCommands.friend(userLoggedIn, getRequestType[index])) {
                                        ok = false;
                                        answer.append(getRequestType[index]).append(" ");
                                    }
                                }
                                if(ok)
                                    answer.append("Friends successfully added!");
                                else
                                    answer.append("cannot be added as friends!");
                            }
                            else {
                                answer.append("Please type a username!");
                            }
                        }
                        else {
                            answer.append("You need to be logged in order to add friends!");
                        }
                        break;
                    case "send":
                        if(!userLoggedIn.equals("")) {
                            if(getRequestType.length > 1) {
                                StringBuilder message = new StringBuilder();
                                for(int index = 1; index < getRequestType.length; index++) {
                                    message.append(getRequestType[index]).append(" ");
                                }
                                if(socialNetworkCommands.send(userLoggedIn, message.toString()))
                                    answer.append("Message send!");
                                else
                                    answer.append("Sorry, but you have no friends! ;(");
                            }
                            else {
                                answer.append("Please write a message!");
                            }
                        }
                        else {
                            answer.append("You need to be logged in order to send messages!");
                        }
                        break;
                    case "read":
                        if(!userLoggedIn.equals("")) {
                            if(getRequestType.length == 1) {
                                answer.append(socialNetworkCommands.read(userLoggedIn));
                            }
                            else {
                                answer.append("Wrong 'read' command!");
                            }
                        }
                        else {
                            answer.append("You need to be logged in order to read your messages!");
                        }
                        break;
                    default:
                        answer.append("Wrong command!");
                }

                out.println(answer);
                out.flush();
            }
        } catch (IOException e){
            if(e instanceof SocketTimeoutException)
                System.err.println("Communication error: client timeout expired!");
            else
                System.err.println("Communication error: " + e);
        } finally {
            try{
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println("Server stopped");
                out.flush();
                socket.close();
            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
        }
    }
}
