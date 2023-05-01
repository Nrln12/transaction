package com.bankofbaku.transaction.controller;

import com.bankofbaku.transaction.dto.ClientDto;
import com.bankofbaku.transaction.service.ClientService;
import com.bankofbaku.transaction.service.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;
    @PostMapping("/add-client")
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientDto) throws Exception {
        return ResponseEntity.ok().body(service.addClient(clientDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getClientById(id));
    }
}
