package ubmagh.me.graphqlmicroserviceexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Bank Account not found")
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String customerId){
        super(
          String.format("Cannot find Customer with id : %s", customerId)
        );
    }
}
