package com.bankofbaku.transaction.repository;

import com.bankofbaku.transaction.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByUsername(String username);
}
