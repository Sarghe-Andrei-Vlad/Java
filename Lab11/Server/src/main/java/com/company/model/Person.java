package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.hibernate.boot.model.source.spi.Orderable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"friends", "numberOfFriends"
})
@Table(name="persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;
    @Column(name="name")
    String name;
    @Column(name="numberOfFriends")
    long numberOfFriends;
    @ManyToMany(fetch = FetchType.LAZY)
    List<Person> friends;

    public void addFriend(Person person)
    {
        friends.add(person);
    }
}
