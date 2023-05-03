package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.TransactionDto;
import com.bankofbaku.transaction.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public interface TransactionService {
    //TransactionDto addTransaction(TransactionDto transactionDto);

//    List<TransactionDto> getTransactionByReceiverId(Long receiverId);
    Long getAmountByAccount(Double id);
}

