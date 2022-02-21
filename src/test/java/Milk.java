import lombok.Builder;
import lombok.Getter;

@Builder
public class Milk implements Items {

    Double price;
    int quantity;
    String measurementUnit;

    @Override
    public String getItemName() {
        return itemName;
    }

    String itemName="Milk";

    @Override
    public Double getPrice() {
        this.price =price;
        return this.price;
    }

    @Override
    public int getQuantity() {
        this.quantity =quantity;
        return this.quantity;
    }

    @Override
    public String getMeasurementUnit() {
        this.measurementUnit =measurementUnit;
        return this.measurementUnit;
    }

}
