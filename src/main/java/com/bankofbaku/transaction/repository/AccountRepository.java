package com.bankofbaku.transaction.repository;

import com.bankofbaku.transaction.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> getAllAccounts();
    Account getAccountById(Long accountId);
}
