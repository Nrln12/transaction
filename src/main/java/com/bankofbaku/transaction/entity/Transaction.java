package com.bankofbaku.transaction.entity;
import com.bankofbaku.transaction.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private LocalDateTime date;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private EStatus status;
    @ManyToOne
    @JoinColumn(name="sender_account")
    @JsonIgnore
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name="receiver_account")
    @JsonIgnore
    private Account receiverAccount;
}
