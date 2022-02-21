import lombok.Builder;
import lombok.Getter;

@Builder
public class Apple implements Items {

    Double price;
    int quantity;
    String measurementUnit,itemName;

    @Override
    public Double getPrice(Double price) {
        this.price =price;
        return this.price;
    }

    @Override
    public int getQuantity(int quantity) {
        this.quantity =quantity;
        return this.quantity;
    }

    @Override
    public String getMeasurementUnit(String measurementUnit) {
        this.measurementUnit =measurementUnit;
        return this.measurementUnit;
    }

    @Override
    public String getItemName(String itemName) {
        this.itemName =itemName;
        return this.itemName;
    }
}
