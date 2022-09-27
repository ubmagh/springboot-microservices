package ubmagh.me.graphqlmicroserviceexample.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ubmagh.me.graphqlmicroserviceexample.dtos.BankAccountRequestDto;
import ubmagh.me.graphqlmicroserviceexample.entities.BankAccount;
import ubmagh.me.graphqlmicroserviceexample.exceptions.BankAccountNotFoundException;
import ubmagh.me.graphqlmicroserviceexample.mappers.BankAccountMapers;
import ubmagh.me.graphqlmicroserviceexample.repositories.BankAccountRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;


    @Override
    public List<BankAccount> getAllAccounts() {
        return this.bankAccountRepository.findAll();
    }

    @Override
    public BankAccount getBankAccount(String id) throws BankAccountNotFoundException {
        return this.bankAccountRepository.findById( id).orElseThrow( ()-> new BankAccountNotFoundException(id));
    }

    @Override
    public Page<BankAccount> paginateBankAccounts(int size, int page) {
        return this.bankAccountRepository.findAll(PageRequest.of( page, size));
    }

    @Override
    public BankAccount createAccount(BankAccountRequestDto accounty) {
        BankAccount account = BankAccountMapers.fromBankAccountRequestDtoToBankAccount( accounty );
        account.setCreatedAt( (new Date()).getTime() );
        account.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(account);
    }

    @Override
    public boolean deleteAccountById(String id)  throws BankAccountNotFoundException{
        BankAccount account = this.getBankAccount(id);
        bankAccountRepository.deleteById(id);
        return true;
    }

    @Override
    public BankAccount updateBankAccount(String id, BankAccount account) throws BankAccountNotFoundException {
        BankAccount currentAcc = this.getBankAccount(id);
        if( account.getBalance() != null) currentAcc.setBalance(account.getBalance());
        if( account.getCurrency() != null) currentAcc.setCurrency(account.getCurrency());
        if( account.getType() != null) currentAcc.setType( account.getType());
        return bankAccountRepository.save(account);
    }

    @Override
    public BankAccount updateBankAccount( String id, BankAccountRequestDto account ) throws BankAccountNotFoundException{
        BankAccount tmp = BankAccountMapers.fromBankAccountRequestDtoToBankAccount(account);
        return this.updateBankAccount(id, tmp);
    }
}
