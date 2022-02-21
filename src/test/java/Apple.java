import lombok.Builder;
import lombok.Getter;

@Builder
public class Apple implements Items {

    private Double price;
    private int quantity;
    private String measurementUnit;
    private String itemName="Apple";

    @Override
    public String getItemName() {
        return itemName;
    }



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
