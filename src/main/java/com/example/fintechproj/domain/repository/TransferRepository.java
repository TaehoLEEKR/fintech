package com.example.fintechproj.domain.repository;

import com.example.fintechproj.domain.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<Transfer,Long> {
    List<Transfer> findBySenderAccountNum(String accountNum);
}