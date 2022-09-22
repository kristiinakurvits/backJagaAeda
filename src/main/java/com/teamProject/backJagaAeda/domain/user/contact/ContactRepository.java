package com.teamProject.backJagaAeda.domain.user.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("select (count(c) > 0) from Contact c where c.user.userName = ?1")
    boolean existBy(String userName);

    @Query("select c from Contact c where c.user.id = ?1")
    Optional<Contact> findByUserId(Integer id);
}