package com.bankofbaku.transaction.repository;

import com.bankofbaku.transaction.dto.TransactionDto;
import com.bankofbaku.transaction.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> getTransactionByReceiverAccountAccountId(Long receiverId);
    List<Transaction> getTransactionBySenderAccountAccountId(Long senderId);
    @Query(value = "select getCirc(?)", nativeQuery = true)
    Double getAmountByAccount(Double id);
}
/*
delimiter //
create function getCirc(id bigint)
returns double  reads sql data
begin
	declare circ double;
    declare all_amount_pos double;
    declare all_amount_neg double;
    select sum(amount) into all_amount_pos from transaction where receiver_account=id AND status = 'SUCCESS';
    select (-1)*sum(amount) into all_amount_neg from transaction where sender_account=id AND status = 'SUCCESS';
	set circ = all_amount_pos + all_amount_neg;
    return circ;
end //
delimiter ;
select getCirc(3);
 */