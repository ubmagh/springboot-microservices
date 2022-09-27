package ubmagh.me.microservicerestendpoints.web;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ubmagh.me.microservicerestendpoints.dtos.BankAccountRequestDto;
import ubmagh.me.microservicerestendpoints.entities.BankAccount;
import ubmagh.me.microservicerestendpoints.services.BankAccountService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v0")
public class AccountRestController {

    private BankAccountService bankAccountService;

    @GetMapping("/BankAccounts")
    public List<BankAccount> bankAccounts(){
        return this.bankAccountService.getAllAccounts();
    }

    @GetMapping("/PaginateBankAccounts")
    public Page<BankAccount> bankAccounts(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "0") int size ){
        return this.bankAccountService.paginateBankAccounts(size, page);
    }

    @GetMapping("/BankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable("id") String id){
        BankAccount account = null;
        account = this.bankAccountService.getBankAccount(id);
        return account;
    }


    @PostMapping("/BankAccounts")
    public BankAccount saveAccount(@RequestBody BankAccountRequestDto account){
        return this.bankAccountService.createAccount( account);
    }

    @PutMapping("/BankAccounts/{id}")
    public BankAccount updateAccount( @PathVariable("id") String id, @RequestBody BankAccount account){
        return bankAccountService.updateBankAccount( id, account);
    }


    @DeleteMapping("/BankAccounts/{id}")
    public void deleteAccount( @PathVariable("id") String id){
        this.bankAccountService.deleteAccountById( id );
    }

}
