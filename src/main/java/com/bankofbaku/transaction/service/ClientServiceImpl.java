package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.ClientDto;
import com.bankofbaku.transaction.entity.Client;
import com.bankofbaku.transaction.exception.BadRequestException;
import com.bankofbaku.transaction.exception.IsNotValidException;
import com.bankofbaku.transaction.exception.NotFoundException;
import com.bankofbaku.transaction.repository.ClientRepository;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;
    private final ModelMapper mapper;
    public ClientServiceImpl(ClientRepository clientRepository,ModelMapper mapper){
        this.clientRepository=clientRepository;
        this.mapper=mapper;
    }
    public ClientDto getClientById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        if(!client.isPresent()) throw new NotFoundException("User has not found");
        return mapper.map(client, ClientDto.class);
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
        return clientDto;
    }


    public boolean isValidUsername(String username){
        String regex = "^[a-zA-Z0-9._-]{3,}$";
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
