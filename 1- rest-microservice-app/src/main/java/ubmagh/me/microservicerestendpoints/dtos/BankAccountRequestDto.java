package ubmagh.me.microservicerestendpoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ubmagh.me.microservicerestendpoints.enums.AccountType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountRequestDto {


    private Double balance;

    private String currency;

    private AccountType type;

}
