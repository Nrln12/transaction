package com.bankofbaku.transaction.controller;

import com.bankofbaku.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/receieverId/{receieverId}")
    public ResponseEntity getReceieverTransaction(@PathVariable Long receieverId){
        return ResponseEntity.ok().body(transactionService.getTransactionByReceiverId(receieverId));
    }
    @GetMapping()
    public ResponseEntity getTransaction(){
        return ResponseEntity.ok().body(transactionService.getTransactions());
    }
}
