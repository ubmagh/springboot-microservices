package ubmagh.me.graphqlmicroserviceexample.mappers;

import org.springframework.beans.BeanUtils;
import ubmagh.me.graphqlmicroserviceexample.dtos.BankAccountRequestDto;
import ubmagh.me.graphqlmicroserviceexample.entities.BankAccount;

public class BankAccountMapers {

    public static BankAccount fromBankAccountRequestDtoToBankAccount(BankAccountRequestDto request){
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties( request, bankAccount );
        return bankAccount;
    }

}
