package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.TransactionDto;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    TransactionDto addTransaction(TransactionDto transactionDto);
}

