package com.bankofbaku.transaction.repository;

import com.bankofbaku.transaction.dto.AccountDto;
import com.bankofbaku.transaction.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountCode(Long accountCode);
    List<Account> findByClientId(Long clientId);
    List<Account> findByAccountType(String accountType);
    List<Account> findAll();
}
