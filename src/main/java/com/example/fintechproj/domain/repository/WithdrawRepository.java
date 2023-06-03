package com.example.fintechproj.domain.repository;

import com.example.fintechproj.domain.model.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawRepository extends JpaRepository<Withdraw , Long> {
}
