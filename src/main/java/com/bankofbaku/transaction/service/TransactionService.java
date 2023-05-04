package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.TransactionDto;
import com.bankofbaku.transaction.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public interface TransactionService {
    //TransactionDto addTransaction(TransactionDto transactionDto);

    List<TransactionDto> getTransactionByReceiverAccountAccountId(Long receiverId);
    List<TransactionDto> getTransactionBySenderAccountAccountId(Long senderId);
    Double getAmountByAccount(Double id);
}

