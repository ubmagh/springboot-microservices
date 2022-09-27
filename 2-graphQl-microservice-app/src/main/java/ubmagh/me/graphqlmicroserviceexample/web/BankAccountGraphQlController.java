package ubmagh.me.graphqlmicroserviceexample.web;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ubmagh.me.graphqlmicroserviceexample.dtos.BankAccountRequestDto;
import ubmagh.me.graphqlmicroserviceexample.dtos.CustomerRequestDto;
import ubmagh.me.graphqlmicroserviceexample.entities.BankAccount;
import ubmagh.me.graphqlmicroserviceexample.entities.Customer;
import ubmagh.me.graphqlmicroserviceexample.services.BankAccountService;
import ubmagh.me.graphqlmicroserviceexample.services.CustomerService;

import java.util.List;

@AllArgsConstructor
@Controller
public class BankAccountGraphQlController {

    private BankAccountService bankAccountService;
    private CustomerService customerService;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return this.bankAccountService.getAllAccounts();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return this.bankAccountService.getBankAccount(id);
    }

    @MutationMapping
    public BankAccount addAccount(@Argument BankAccountRequestDto bankAccount) {
        return this.bankAccountService.createAccount( bankAccount );
    }

    @MutationMapping
    public BankAccount update( @Argument String id, @Argument BankAccountRequestDto bankAccount) {
        return this.bankAccountService.updateBankAccount( id, bankAccount );
    }

    @MutationMapping
    public String deleteAccount( @Argument String id ) {
        this.bankAccountService.deleteAccountById( id );
        return id;
    }



    @QueryMapping
    public List<Customer> customersList(){
        return this.customerService.getAllCustomers();
    }

    @QueryMapping
    public Customer customerById(@Argument String id){
        return this.customerService.findById(id);
    }

    @MutationMapping
    public Customer addCustomer(@Argument CustomerRequestDto cs) {
        return this.customerService.createCustomer( cs );
    }

    @MutationMapping
    public Customer updateCustomer( @Argument String id, @Argument CustomerRequestDto cs) {
        return this.customerService.updateCustomer( id, cs );
    }

    @MutationMapping
    public String deleteCustomer( @Argument String id ) {
        this.customerService.deleteCustomer( id );
        return id;
    }

}

/* // valid starting from java 14
record BankAccountRequestDto( Double balance, String type, String currency ){
}
 */