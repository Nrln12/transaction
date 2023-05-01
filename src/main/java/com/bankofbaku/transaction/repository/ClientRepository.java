package com.bankofbaku.transaction.repository;

import com.bankofbaku.transaction.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllClient();
    Client findClientById(Long clientId);
    Client findClientByUsername(String username);
}
