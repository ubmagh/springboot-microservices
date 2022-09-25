package ubmagh.me.microservicerestendpoints.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection( types = BankAccount.class, name = "p1")
public interface AccountProjection {

    // http://localhost:8081/api/v1/bankAccounts?projection=p1

    public String getId();
    public String getType();
    public Double getBalance();
}
