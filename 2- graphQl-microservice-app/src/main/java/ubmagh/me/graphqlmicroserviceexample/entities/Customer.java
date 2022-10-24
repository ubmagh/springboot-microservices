package ubmagh.me.graphqlmicroserviceexample.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Customer {

    @javax.persistence.Id
    private String Id;

    private String name;

    @OneToMany( mappedBy = "customerId")
    private List<BankAccount> accounts;

}
