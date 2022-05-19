package network;

import java.util.ArrayList;

public class SocialNetworkCommands {
    private SocialNetwork socialNetwork = null;

    public SocialNetworkCommands(){
        socialNetwork = SocialNetwork.getInstance();
    }

    public boolean register(String username){
        if(!socialNetwork.socialNetworkUsers.containsKey(username)){
            socialNetwork.socialNetworkUsers.put(username, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean delete(String username){
        if(!socialNetwork.socialNetworkUsers.containsKey(username))
            return false;
        socialNetwork.socialNetworkUsers.remove(username);
        return true;
    }

    public boolean login(String username){
        if(!socialNetwork.socialNetworkUsers.containsKey(username) || socialNetwork.socialNetworkUsers.size() == 0)
            return false;
        return true;
    }

    public boolean friend(String username, String newFriend){
        if(!socialNetwork.socialNetworkUsers.containsKey(newFriend) || username.equals(newFriend))
            return false;

        if(!socialNetwork.socialNetworkUsers.get(username).contains(newFriend))
            socialNetwork.socialNetworkUsers.get(username).add(newFriend);
        return true;
    }

    public boolean send(String username, String message){
        if(socialNetwork.socialNetworkUsers.get(username).size() == 0)
            return false;
        for(String friend : socialNetwork.socialNetworkUsers.get(username)) {
            if(!socialNetwork.usersMessages.containsKey(friend))
                socialNetwork.usersMessages.put(friend,new ArrayList<>());
            socialNetwork.usersMessages.get(friend).add(username + ": " + message);
        }
        return true;
    }

    public String read(String username){
        if(!socialNetwork.usersMessages.containsKey(username))
            return "Sorry, you have 0 messages!";
        StringBuilder messages = new StringBuilder();
        for(String message : socialNetwork.usersMessages.get(username)){
            messages.append(message).append(" | ");
        }
        return messages.toString();
    }
}
