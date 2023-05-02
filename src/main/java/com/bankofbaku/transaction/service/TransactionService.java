package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.TransactionDto;
import com.bankofbaku.transaction.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    //TransactionDto addTransaction(TransactionDto transactionDto);
    List<TransactionDto> getTransactionByReceiverId(Long receieverId);
    String getTransactions();
}

