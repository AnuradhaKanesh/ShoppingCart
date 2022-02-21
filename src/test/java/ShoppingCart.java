import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class ShoppingCart {
    private List<Items> items;
    @Setter
    private double totalCartValue;

}
