package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.ClientDto;

public interface ClientService {
    ClientDto addClient(ClientDto clientDto) throws Exception;
}
