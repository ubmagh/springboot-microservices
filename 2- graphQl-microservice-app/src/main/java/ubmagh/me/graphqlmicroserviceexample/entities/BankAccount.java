package ubmagh.me.graphqlmicroserviceexample.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ubmagh.me.graphqlmicroserviceexample.enums.AccountType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {

    @Id
    private String id;

    private Long createdAt ; // Date is not a primitive type know by graphQl

    private Double balance;

    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToOne
    private Customer customerId;

}
