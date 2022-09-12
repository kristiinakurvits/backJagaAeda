package com.teamProject.backJagaAeda.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.userName = ?1 and u.password = ?2")
    User findByUserNameAndPassword(String userName, String password);



}