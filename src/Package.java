import java.time.LocalDate;

public class Package implements Comparable<Package> {
    String trackingNumber;
    Address senderAddress, recipientAddress;
    LocalDate estimatedDeliveryDate;

    public Package(String trackingNumber, Address senderAddress, Address recipientAddress, LocalDate estimatedDeliveryDate) {
        this.trackingNumber = "AS00"+trackingNumber;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public int compareTo(Package otra) {
        return this.trackingNumber.compareTo(otra.trackingNumber) ;
    }

    @Override
    public String toString() {
        return "\nTracking Number: " + this.trackingNumber + ", sender Address City: " + this.senderAddress.city+
                ", sender Address State: " + this.senderAddress.state+
                ", sender Address street: " + this.senderAddress.street+
                ", sender Address Zipcode: " + this.senderAddress.zipCode+
                ", \nrecipient Address City: "+this.recipientAddress.city +
                ", recipient Address State: "+this.recipientAddress.state+
                ", recipient Address Street: "+this.recipientAddress.street +
                ", recipient Address Zipcode: "+this.recipientAddress.zipCode +
                "\n";
    }
}

