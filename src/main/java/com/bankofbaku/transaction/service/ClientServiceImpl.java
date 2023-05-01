package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.ClientDto;
import com.bankofbaku.transaction.entity.Client;
import com.bankofbaku.transaction.exception.BadRequestException;
import com.bankofbaku.transaction.exception.IsNotValidException;
import com.bankofbaku.transaction.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class ClientServiceImpl  implements ClientService{
    private final ClientRepository clientRepository;
    private final ModelMapper mapper;
    public ClientServiceImpl(ClientRepository clientRepository,ModelMapper mapper){
        this.clientRepository=clientRepository;
        this.mapper=mapper;
    }
    @Override
    public ClientDto addClient(ClientDto clientDto) throws Exception {
        Optional<Client> checkClient = Optional.ofNullable(clientRepository.findClientByUsername(clientDto.getUsername()));
        if (checkClient.isPresent()) throw new BadRequestException("The username has already taken.");
        try {

            if (!isValidUsername(clientDto.getUsername())) throw new IsNotValidException("The username is not valid");
            if (!isValidPassword(clientDto.getPassword())) throw new IsNotValidException("The password is not valid");
            clientDto.setPassword(encodePassword(clientDto.getPassword()));
            clientRepository.save(mapper.map(clientDto, Client.class));
        }catch (Exception ex){
            throw new Exception(ex);
        }
   return null;
    }

    public boolean isValidUsername(String username){
        String regex = "  ^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        return username.matches(regex) ? true : false;
    }
    public boolean isValidPassword(String password){
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        return password.matches(regex) ? true : false;
    }
    public String encodePassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
