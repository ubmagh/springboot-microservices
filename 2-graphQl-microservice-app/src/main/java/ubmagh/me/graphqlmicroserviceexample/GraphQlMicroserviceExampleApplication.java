package ubmagh.me.graphqlmicroserviceexample;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ubmagh.me.graphqlmicroserviceexample.entities.BankAccount;
import ubmagh.me.graphqlmicroserviceexample.entities.Customer;
import ubmagh.me.graphqlmicroserviceexample.enums.AccountType;
import ubmagh.me.graphqlmicroserviceexample.repositories.BankAccountRepository;
import ubmagh.me.graphqlmicroserviceexample.repositories.CustomerRepository;
import ubmagh.me.graphqlmicroserviceexample.services.CustomerService;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class GraphQlMicroserviceExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlMicroserviceExampleApplication.class, args);
    }


    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args ->{
            Stream.of("Mohamed", "Ayoub", "Mouad").forEach(c->{

                Customer customer = Customer.builder().name(c).Id(UUID.randomUUID().toString()).build();
                customer = customerRepository.save(customer);

                for( int i=0; i<10; i++){
                    BankAccount account = BankAccount.builder()
                            .id( UUID.randomUUID().toString() )
                            .type(Math.random()>0.5? AccountType.Current_Account:AccountType.Saving_Account)
                            .balance(77*1000*Math.random()+55)
                            .createdAt( (new Date()).getTime() )
                            .currency("MAD")
                            .customerId( customer )
                            .build();
                    bankAccountRepository.save( account );

                }

            });

            log.info("DATA faked !!");
        };
    }

}
