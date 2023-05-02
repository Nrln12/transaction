package com.bankofbaku.transaction.entity;

import com.bankofbaku.transaction.enums.EGender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    @Column(name = "birthdate", columnDefinition = "DATE")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthdate;
    private String name;
    private String surname;
    private String middlename;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Account> accounts;
}