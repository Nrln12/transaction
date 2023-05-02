package com.bankofbaku.transaction.controller;

import com.bankofbaku.transaction.dto.AccountDto;
import com.bankofbaku.transaction.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("add-account")
    public ResponseEntity addAccount(@RequestBody AccountDto accountDto) throws Exception {
        return ResponseEntity.ok().body(accountService.addAccount(accountDto));
    }
    @GetMapping("/accountCode/{accountCode}")
    public ResponseEntity getAccountByAccountCode(@PathVariable Long accountCode){
        return ResponseEntity.ok().body(accountService.getAccountByAccountCode(accountCode));
    }
    @GetMapping("/clientId/{clientId}")
    public ResponseEntity getAccountByClientId(@PathVariable Long clientId){
        return ResponseEntity.ok().body(accountService.getAccountByClientId(clientId));
    }
    @GetMapping("/accountType")
    public ResponseEntity getAccountByType(@RequestParam String type){
        return ResponseEntity.ok().body(accountService.getAccountByAccountType(type));
    }
    @GetMapping("/allAccounts")
    public ResponseEntity getAllAccounts(){
        return ResponseEntity.ok().body(accountService.getAllAccounts());
    }
}
