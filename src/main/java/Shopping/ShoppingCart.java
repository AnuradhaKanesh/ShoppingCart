package Shopping;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ShoppingCart {
    public ShoppingCart() {
        items = new ArrayList<Items>();
    }

    private List<Items> items;
    @Setter
    private double totalCartValue;

}
