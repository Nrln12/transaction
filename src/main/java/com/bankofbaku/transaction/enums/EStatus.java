package com.bankofbaku.transaction.enums;

public enum EStatus {
    WAITING,
    REVERSED,
    SUCCESS
}
//DELIMITER //
//CREATE DEFINER=`root`@`localhost` PROCEDURE getTransactionByReceiverId(IN receiverId bigint)
//BEGIN
//	select * from transaction where receiver_account=receiverId AND status = 'SUCCESS';
//END //
//DELIMITER ;
//call getTransactionByReceiverId(3);