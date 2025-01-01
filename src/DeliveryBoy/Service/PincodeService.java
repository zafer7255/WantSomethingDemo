package DeliveryBoy.Service;

import DeliveryBoy.DatabaseSaved.DeliveryBoySaved;
import DeliveryBoy.Model.DeliveryBoyDetail;

public class PincodeService {
    DeliveryBoySaved deliveryBoySaved = new DeliveryBoySaved();
    //private DeliveryBoyDetail deliveryBoyDetail = new DeliveryBoyDetail();
    public void pincodeRegister(DeliveryBoyDetail deliveryBoyDetail) {
        for (int i = 0; i < deliveryBoyDetail.getAllPincode().size(); i++) {
            int currentIndex = i; // Capture the current index value

            Runnable task = new Runnable() {
                @Override
                public void run() {
                    int pincode = deliveryBoyDetail.getAllPincode().get(currentIndex);
                    deliveryBoySaved.InsertUniquePincode(pincode);
                }
            };

            Thread thread = new Thread(task);
            thread.start();
        }
        System.out.println("All Pincode saved successfully!");
    }
}
