package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    ClientDto addClient(ClientDto clientDto) throws Exception;
    ClientDto getClientById(Long clientId);
    List<ClientDto> getAllClients();
}
