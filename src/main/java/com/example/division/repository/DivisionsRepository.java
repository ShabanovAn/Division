package com.example.division.repository;

import com.example.division.entity.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface DivisionsRepository extends JpaRepository<Divisions, Integer> {

    @Query(value = "select * from divisions where creation_date = ?", nativeQuery = true)
    List<Divisions> findAllByCreation_date(LocalDateTime date);

}