package ubmagh.me.microservicerestendpoints;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ubmagh.me.microservicerestendpoints.entities.BankAccount;
import ubmagh.me.microservicerestendpoints.enums.AccountType;
import ubmagh.me.microservicerestendpoints.repositories.BankAccountRepository;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroserviceRestEndpointsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceRestEndpointsApplication.class, args);
    }

    @Bean
    CommandLineRunner start( BankAccountRepository bankAccountRepository){
        return args ->{
            for( int i=0; i<10; i++){
                BankAccount account = BankAccount.builder()
                        .id( UUID.randomUUID().toString() )
                        .type(Math.random()>0.5? AccountType.Current_Account:AccountType.Saving_Account)
                        .balance(77*1000*Math.random()+55)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
                bankAccountRepository.save( account );
            }
        };
    }

}
