package com.bankofbaku.transaction.service;

import com.bankofbaku.transaction.dto.TransactionDto;
import com.bankofbaku.transaction.entity.Transaction;
import com.bankofbaku.transaction.enums.EOperationType;
import com.bankofbaku.transaction.exception.NotFoundException;
import com.bankofbaku.transaction.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bankofbaku.transaction.enums.EOperationType.*;

@Service
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;
    private final ModelMapper mapper;
//    @PersistenceContext
//    @Autowired
//    private EntityManager em;
    public TransactionServiceImpl(TransactionRepository transactionRepository, ModelMapper mapper){
        this.transactionRepository=transactionRepository;
        this.mapper=mapper;
    }
//        @Override
//    public List<TransactionDto> getTransactionByReceiverId(Long receieverId) {
//        List<TransactionDto> transactions = transactionRepository.getTransactionByReceiverId(receieverId).stream()
//                .map(transaction -> mapper.map(transaction, TransactionDto.class))
//                .collect(Collectors.toList());
//        transactions.stream().forEach(transactionDto -> transactionDto.setOperationType(DEBIT));
//        return transactions;
//    }

//    @Override
//    public List<TransactionDto> getTransactionByReceiverId(Long receiverId) {
//        List<TransactionDto> transactionDtos = (List<TransactionDto>) em.createNamedStoredProcedureQuery("getTransactionByReceiverId").setParameter("receiverId",receiverId)
//                .getResultList().stream().map(transaction-> mapper.map(transaction,TransactionDto.class)).collect(Collectors.toList());
//        if(transactionDtos.isEmpty()){
//            throw new NotFoundException("Transaction doesn't exist");
//        }
//        return transactionDtos;
//
//    }

    @Override
    public List<TransactionDto> getTransactionByReceiverAccountAccountId(Long receiverId) {
        List<Transaction> transactions = transactionRepository.getTransactionByReceiverAccountAccountId(receiverId);
        if(transactions.isEmpty()) throw new NotFoundException("Invalid receiver account id");
        List<TransactionDto> transactionDtos = transactions.stream().map(transaction -> mapper.map(transaction, TransactionDto.class)).collect(Collectors.toList());
        transactionDtos.forEach(transactionDto -> transactionDto.setOperationType(DEBIT));
        return transactionDtos;
    }

    @Override
    public List<TransactionDto> getTransactionBySenderAccountAccountId(Long senderId) {
        List<Transaction> transactions = transactionRepository.getTransactionBySenderAccountAccountId(senderId);
        if(transactions.isEmpty()) throw new NotFoundException("Invalid sender account id");
        List<TransactionDto> transactionDtos = transactions.stream().map(transaction -> mapper.map(transaction, TransactionDto.class)).collect(Collectors.toList());
        transactionDtos.forEach(transactionDto -> transactionDto.setOperationType(CREDIT));
        return transactionDtos;
    }

    @Override
    public Double getAmountByAccount(Double id) {
        return transactionRepository.getAmountByAccount(id);
    }


}
