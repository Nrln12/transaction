package com.bankofbaku.transaction.entity;

import com.bankofbaku.transaction.enums.EAccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private Long accountCode;
    private Long clientId;
    private LocalDateTime openDate;
    @Enumerated(EnumType.STRING)
    private EAccountType accountType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client client;
    @OneToMany(mappedBy="senderAccount", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Transaction> senders;
    @OneToMany(mappedBy="receiverAccount", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Transaction> receivers;
}
