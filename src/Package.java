import java.time.LocalDate;

public class Package {
    String trackingNumber;
    Address senderAddress, recipientAddress;
    LocalDate estimatedDeliveryDate;

    public Package(String trackingNumber, Address senderAddress, Address recipientAddress, LocalDate estimatedDeliveryDate) {
        this.trackingNumber = trackingNumber;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }


}
