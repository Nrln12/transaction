package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.TransactionDto;
import com.bankofbaku.transaction.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;
    private final ModelMapper mapper;
    public TransactionServiceImpl(TransactionRepository transactionRepository, ModelMapper mapper){
        this.transactionRepository=transactionRepository;
        this.mapper=mapper;
    }

    @Override
    public TransactionDto addTransaction(TransactionDto transactionDto) {

        return null;
    }


}
