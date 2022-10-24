package ubmagh.me.microservicerestendpoints.mappers;

import org.springframework.beans.BeanUtils;
import ubmagh.me.microservicerestendpoints.dtos.BankAccountRequestDto;
import ubmagh.me.microservicerestendpoints.entities.BankAccount;

public class BankAccountMapers {

    public static BankAccount fromBankAccountRequestDtoToBankAccount(BankAccountRequestDto request){
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties( request, bankAccount );
        return bankAccount;
    }

}
