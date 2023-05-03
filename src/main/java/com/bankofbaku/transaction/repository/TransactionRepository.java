package com.bankofbaku.transaction.repository;

import com.bankofbaku.transaction.dto.TransactionDto;
import com.bankofbaku.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Procedure(name="getTransactionByReceiverId")
    List<Transaction> getTransactionByReceiverId(Long receiverId);
   @Modifying
    @Query(value = "select get_tr)", nativeQuery = true)
    String getTransactions();
}
