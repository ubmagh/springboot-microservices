package ubmagh.me.graphqlmicroserviceexample.entities;

public interface AccountProjection {

    // http://localhost:8081/api/v1/bankAccounts?projection=p1

    public String getId();
    public String getType();
    public Double getBalance();
}
