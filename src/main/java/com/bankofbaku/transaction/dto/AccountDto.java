package com.bankofbaku.transaction.dto;

import com.bankofbaku.transaction.enums.EAccountType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountDto {
    private Long clientId;
    private Long accountCode;
    private LocalDateTime openDate;
    private EAccountType accountType;
}
