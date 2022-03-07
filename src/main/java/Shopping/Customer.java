package Shopping;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Customer {

    String name;
    ShoppingCart cart;
    eWallet wallet;

}
