package ubmagh.me.microservicerestendpoints.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Bank Account not found")
public class BankAccountNotFoundException extends RuntimeException {
    public BankAccountNotFoundException(String accountId){
        super(
          String.format("Cannot find account with id : %s", accountId)
        );
    }
}
