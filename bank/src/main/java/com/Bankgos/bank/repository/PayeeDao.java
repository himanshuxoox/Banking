package com.Bankgos.bank.repository;

import com.Bankgos.bank.model.Payee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayeeDao extends JpaRepository<Payee,Long> {

    List<Payee> findByUserId(Long userId);

}
