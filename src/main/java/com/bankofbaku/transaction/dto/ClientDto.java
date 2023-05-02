package com.bankofbaku.transaction.dto;

import com.bankofbaku.transaction.enums.EGender;
import lombok.Data;

import java.util.Date;

@Data
public class ClientDto {
    private String username;
    private String password;
    private EGender gender;
    private Date birthdate;
    private String name;
    private String surname;
    private String middlename;
}
