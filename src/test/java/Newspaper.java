import lombok.Builder;
import lombok.Getter;

@Builder
public class Newspaper implements Items {

    Double price;
    int quantity;
    String measurementUnit,itemName;

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
