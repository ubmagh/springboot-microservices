package ubmagh.me.graphqlmicroserviceexample.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ubmagh.me.graphqlmicroserviceexample.dtos.BankAccountRequestDto;
import ubmagh.me.graphqlmicroserviceexample.entities.BankAccount;
import ubmagh.me.graphqlmicroserviceexample.exceptions.BankAccountNotFoundException;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface BankAccountService {
    public List<BankAccount> getAllAccounts();
    public BankAccount getBankAccount( String id )  throws BankAccountNotFoundException;
    public Page<BankAccount> paginateBankAccounts(int size, int page);
    public BankAccount createAccount(BankAccountRequestDto account);
    public boolean deleteAccountById( String id ) throws BankAccountNotFoundException;
    public BankAccount updateBankAccount(String id, BankAccount account) throws BankAccountNotFoundException ;
        public BankAccount updateBankAccount( String id, BankAccountRequestDto account ) throws BankAccountNotFoundException;
}
