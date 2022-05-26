package com.restcontroller;

import com.model.Person;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class WebService {
    final Logger log = LoggerFactory.getLogger(WebService.class);
    String uri="http://localhost:8082/person";

    RestTemplate restTemplate= new RestTemplate();

    //Get persons
    @GetMapping()
    public List<Person> getPersons()
    {
        log.info("Start");

        ResponseEntity<List<Person>> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Person>>(){});
        List<Person> result = response.getBody();
        result.forEach(p -> log.info(p.toString()));
        log.info("Stop");
        return result;
    }
    //save person
    @PostMapping()
    public ResponseEntity<String> savePerson (String name)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject jsonObject = new JSONObject();
        jsonObject .put("name", name);

        HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject , headers);

        ResponseEntity<String> response=restTemplate.exchange(uri,HttpMethod.POST,entity,String.class);
        log.info(response.getBody());
        return response;
    }

    //update person
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(Long id, String name)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String tempUri= uri+"/"+id;
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(tempUri)
                .queryParam("name", "{name}")
                .encode()
                .toUriString();
        Map<String, String> params = new HashMap<>();
        params.put("name",name);

        ResponseEntity<String> response = restTemplate.exchange(urlTemplate,HttpMethod.PUT,entity,String.class,params);
        log.info(response.getBody());
        return response;

    }

    //delete person
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(Long id)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String tempUri= uri+"/"+id;

        ResponseEntity<String> response = restTemplate.exchange(tempUri,HttpMethod.DELETE,entity,String.class);
        log.info(response.getBody());
        return response;

    }

    //get friends
    @GetMapping("/friends")
    public List<Person> getFriends(Long id)
    {
        String tempUri= uri+"/friends/"+id;
        log.info("Start");

        ResponseEntity<List<Person>> response = restTemplate.exchange(
                tempUri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Person>>(){});
        List<Person> result = response.getBody();
        result.forEach(p -> log.info(p.toString()));
        log.info("Stop");
        return result;
    }

    //add friends
    @PostMapping("/friends")
    public ResponseEntity<String> addFriend(Long id, String name)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String tempUri= uri+"/friends/"+id;
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(tempUri)
                .queryParam("name", "{name}")
                .encode()
                .toUriString();
        Map<String, String> params = new HashMap<>();
        params.put("name",name);

        ResponseEntity<String> response = restTemplate.exchange(urlTemplate,HttpMethod.POST,entity,String.class,params);
        log.info(response.getBody());
        return response;

    }

    //get top
    @GetMapping("/top")
    public List<Person> getTop() {
        String tempUri= uri+"/top";
        log.info("Start");

        ResponseEntity<List<Person>> response = restTemplate.exchange(
                tempUri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Person>>(){});
        List<Person> result = response.getBody();
        result.forEach(p -> log.info(p.toString()));
        log.info("Stop");
        return result;
    }
}

