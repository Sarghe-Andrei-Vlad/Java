package network;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetwork {
    private static volatile SocialNetwork instance = null;
    protected volatile Map<String, List<String>> socialNetworkUsers;
    protected volatile Map<String, List<String>> usersMessages;

    private SocialNetwork() {
        socialNetworkUsers = new HashMap<>();
        usersMessages = new HashMap<>();
    }

    public static SocialNetwork getInstance(){
        if(instance == null){
            synchronized (SocialNetwork.class){
                if(instance == null){
                    instance = new SocialNetwork();
                }
            }
        }
        return instance;
    }

    public Map<String, List<String>> getSocialNetworkUsers(){
        return socialNetworkUsers;
    }
}
