package com.teamProject.backJagaAeda.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("select (count(c) > 0) from Contact c where c.user.userName = ?1")
    boolean existBy(String userName);

}