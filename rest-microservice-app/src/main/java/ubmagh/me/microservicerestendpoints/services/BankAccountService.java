package ubmagh.me.microservicerestendpoints.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ubmagh.me.microservicerestendpoints.dtos.BankAccountRequestDto;
import ubmagh.me.microservicerestendpoints.entities.BankAccount;
import ubmagh.me.microservicerestendpoints.exceptions.BankAccountNotFoundException;


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
    public BankAccount updateBankAccount( String id, BankAccount account ) throws BankAccountNotFoundException;
}
