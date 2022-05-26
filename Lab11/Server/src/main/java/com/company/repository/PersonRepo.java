package com.company.repository;

import com.company.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person,Long> {
    List<Person> findTop3ByOrderByNumberOfFriendsDesc();
}
