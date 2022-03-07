package Shopping;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Items {


    private AvailableItem.Item itemName;
    private Double price;
    private int quantity;
    private String measurementUnit;
    private int availableQuantity;

}
