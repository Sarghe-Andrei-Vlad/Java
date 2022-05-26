package com.company.controller;

import com.company.model.Person;
import com.company.service.FriendService;
import com.company.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person/friends")
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonFriends (@PathVariable Long id)
    {
        List<Person> friends = friendService.getFriends(id);
        if (friends.isEmpty())
        {
            return new ResponseEntity<>("The person doesnt have any friends.",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(friends);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> saveFriend (@PathVariable Long id, @RequestParam String name)
    {
        if (name==null)
            return new ResponseEntity<>("Bad request",HttpStatus.BAD_REQUEST);
        if (!friendService.saveFriend(id,name))
            return new ResponseEntity<>("Cannot add friend.", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Friend added successfully", HttpStatus.CREATED);
    }

}
