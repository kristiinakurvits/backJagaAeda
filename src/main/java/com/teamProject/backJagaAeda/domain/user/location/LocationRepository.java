package com.teamProject.backJagaAeda.domain.user.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select l from Location l where l.contact.id = ?1")
    List<Location> findContactLocationsBy(Integer contactId);
}