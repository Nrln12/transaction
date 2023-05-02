package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.TransactionDto;
import com.bankofbaku.transaction.entity.Transaction;
import com.bankofbaku.transaction.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.bankofbaku.transaction.enums.EOperationType.*;

@Service
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;
    private final ModelMapper mapper;
    public TransactionServiceImpl(TransactionRepository transactionRepository, ModelMapper mapper){
        this.transactionRepository=transactionRepository;
        this.mapper=mapper;
    }
        @Override
    public List<TransactionDto> getTransactionByReceiverId(Long receieverId) {
        List<TransactionDto> transactions = transactionRepository.getTransactionByReceiverId(receieverId).stream()
                .map(transaction -> mapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
        transactions.stream().forEach(transactionDto -> transactionDto.setOperationType(DEBIT));
        return transactions;
    }

    @Override
    public String getTransactions() {
        return transactionRepository.getTransactions();
    }
}
