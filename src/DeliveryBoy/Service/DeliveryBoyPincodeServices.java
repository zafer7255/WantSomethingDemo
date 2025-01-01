package DeliveryBoy.Service;

import DeliveryBoy.DatabaseSaved.DeliveryBoySaved;
import DeliveryBoy.Model.DeliveryBoyDetail;

import java.util.ArrayList;
import java.util.List;

public class DeliveryBoyPincodeServices {
    private DeliveryBoySaved deliveryBoySaved = new DeliveryBoySaved();
    public void rigesterDeliveryBoyPincode(DeliveryBoyDetail deliveryBoyDetail)
    {
        for (int i = 0; i < deliveryBoyDetail.getAllPincode().size(); i++) {
            int currentIndex = i; // Capture the current index value


            Runnable task = new Runnable() {
                @Override
                public void run() {
                    int pincode = deliveryBoyDetail.getAllPincode().get(currentIndex);
                    int id = deliveryBoyDetail.getId();
                    deliveryBoySaved.DeliveryBoyPincode(id , pincode);
                }
            };

            Thread thread = new Thread(task);
            thread.start();
        }
        System.out.println("All deliveryboy with pincode saved successfully!");
    }
}
