package com.example.fintechproj.domain.repository;

import com.example.fintechproj.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByAccountNum(String num);
    List<Account> findByAccountName(String name);
}
