package com.Bankgos.bank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Bankgos.bank.model.User;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);


}
