package com.bankofbaku.transaction.dto;

import com.bankofbaku.transaction.entity.Account;
import com.bankofbaku.transaction.entity.Transaction;
import com.bankofbaku.transaction.enums.EOperationType;
import com.bankofbaku.transaction.enums.EStatus;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private Long transactionId;
    private LocalDateTime date;
    private Double amount;
    private EStatus status;
    private Account senderAccount;
    private Account receiverAccount;
    private EOperationType operationType;
}
