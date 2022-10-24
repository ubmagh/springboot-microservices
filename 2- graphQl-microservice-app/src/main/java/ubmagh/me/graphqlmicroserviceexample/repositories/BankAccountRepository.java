package ubmagh.me.graphqlmicroserviceexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubmagh.me.graphqlmicroserviceexample.entities.BankAccount;


@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
