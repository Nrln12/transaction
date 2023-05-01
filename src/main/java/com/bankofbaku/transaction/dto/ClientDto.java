package com.bankofbaku.transaction.dto;

import com.bankofbaku.transaction.enums.EGender;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ClientDto {
    private String username;
    private String password;
    private EGender gender;
    private LocalDateTime birthdate;
    private String name;
    private String surname;
    private String middlename;
}
