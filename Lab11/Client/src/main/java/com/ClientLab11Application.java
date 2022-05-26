package com;

import com.restcontroller.WebService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientLab11Application {

    public static void main(String[] args) {
        SpringApplication.run(ClientLab11Application.class, args);
        WebService webService = new WebService();
        webService.savePerson("Sarghe");
        webService.savePerson("Onofrei");
        webService.savePerson("Cretu");
        webService.savePerson("Cires");
        webService.savePerson("Cucos");
        webService.getPersons();
        webService.updatePerson(5L,"Cuco");
        webService.getPersons();
        webService.deletePerson(5L);
        webService.getPersons();
        webService.addFriend(1L,"Sarghe");
        webService.addFriend(1L,"Cretu");
        webService.addFriend(3L,"Cires");
        webService.getFriends(1L);
        webService.getTop();
    }
}
