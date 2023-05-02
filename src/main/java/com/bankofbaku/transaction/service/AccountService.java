package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {
    AccountDto addAccount(AccountDto accountDto);
    AccountDto getAccountByAccountCode(Long accountCode);
    List<AccountDto> getAccountByClientId(Long clientId);
    List<AccountDto> getAccountByAccountType(String type);
    List<AccountDto> getAllAccounts();
}
