package com.bankofbaku.transaction.repository;

import com.bankofbaku.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> getTransactionByReceiverAccountAccountId(Long receiverId);
    List<Transaction> getTransactionBySenderAccountAccountId(Long senderId);
    @Query(value = "select getCirc(?)", nativeQuery = true)
    Double getAmountByAccount(Double id);
}
