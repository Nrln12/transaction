package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.AccountDto;
import com.bankofbaku.transaction.entity.Account;
import com.bankofbaku.transaction.enums.EAccountType;
import com.bankofbaku.transaction.exception.BadRequestException;
import com.bankofbaku.transaction.exception.IsNotValidException;
import com.bankofbaku.transaction.exception.NotFoundException;
import com.bankofbaku.transaction.repository.AccountRepository;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{
    private final ModelMapper mapper;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper mapper){
        this.accountRepository=accountRepository;
        this.mapper=mapper;
    }
    @Override
    @SneakyThrows
    public AccountDto addAccount(AccountDto accountDto) {
        Optional<Account> checkAccount = Optional.ofNullable(accountRepository.findByAccountCode(accountDto.getAccountCode()));
        if (checkAccount.isPresent()) throw new BadRequestException("Account has already exist");
        try{
            accountDto.setAccountCode(randomNumberGenerator());
            accountDto.setOpenDate(LocalDateTime.now());
            accountRepository.save(mapper.map(accountDto, Account.class));
        }catch (Exception ex){
            throw new Exception(ex);
        }
        return accountDto;
    }

    @Override
    @SneakyThrows
    public AccountDto getAccountByAccountCode(Long accountCode) {
        Optional<Account> checkAccount = Optional.ofNullable(accountRepository.findByAccountCode(accountCode));
        if(checkAccount.isEmpty()) throw new NotFoundException("Account has not found");
        return mapper.map(checkAccount.get(),AccountDto.class);
    }

    @Override
    public List<AccountDto> getAccountByClientId(Long clientId) {
        List<AccountDto> checkAccount = accountRepository.findByClientId(clientId).stream().map(account-> mapper.map(account, AccountDto.class)).collect(Collectors.toList());
        if (checkAccount.isEmpty()) throw new NotFoundException("This client has no account.");
        return checkAccount;
    }

    @Override
    public List<AccountDto> getAccountByAccountType(String type) {
        if(!isValidAccountType(type)) throw new IsNotValidException("This account type doesn't exist");
        if(accountRepository.findByAccountType(type).isEmpty()) throw new NotFoundException("We have no users in this type.");
        return accountRepository.findByAccountType(type.toUpperCase()).stream().map(account -> mapper.map(account, AccountDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map(account -> mapper.map(account, AccountDto.class)).collect(Collectors.toList());
    }

    public boolean isValidAccountType(String type){
        List<EAccountType> accountTypes= new ArrayList<>();
        return accountTypes.contains(type);
    }

    public Long randomNumberGenerator(){
        Random random = new Random();
        return random.nextLong();
    }
}
