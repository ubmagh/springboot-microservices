package ubmagh.me.microservicerestendpoints.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import ubmagh.me.microservicerestendpoints.entities.BankAccount;
import ubmagh.me.microservicerestendpoints.enums.AccountType;

import java.util.List;

@Repository
@RepositoryRestResource()
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

    public Page<BankAccount> findAll( Pageable pageable );

    //public List<BankAccount> findByType(AccountType type); // http://localhost:8081/api/v1/bankAccounts/search/findByType?type=Current_Account

    @RestResource(path = "/byType")
    public List<BankAccount> findByType( @Param("t") AccountType type); // http://localhost:8081/api/v1/bankAccounts/search/byType?t=Current_Account

}
