import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
@Builder
public class eWallet {
    @Setter
    private double walletBalance = 0.0;


    public void payWithWalletAmount(double amountToPay) {
        Assert.assertTrue(walletBalance < amountToPay,"Not enough balance");
        this.walletBalance -= amountToPay;
    }

}
