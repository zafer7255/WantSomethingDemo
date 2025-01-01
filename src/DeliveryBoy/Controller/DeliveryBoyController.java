package DeliveryBoy.Controller;

import DeliveryBoy.Model.DeliveryBoyDetail;
import DeliveryBoy.Service.DeliveryBoyPincodeServices;
import DeliveryBoy.Service.DeliveryBoyService;
import DeliveryBoy.Service.PincodeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryBoyController {
    private DeliveryBoyService deliveryBoyService = new DeliveryBoyService();
    private PincodeService pincodeService = new PincodeService();
    private DeliveryBoyPincodeServices deliveryBoyPincodeServices = new DeliveryBoyPincodeServices();
    List<Integer> allthePincode = new ArrayList<>();
    public void rigesterDelhiveryBoy(DeliveryBoyDetail deliveryBoyDetail)
    {
        try {
            deliveryBoyService.rigesterDeliveryBoy(deliveryBoyDetail);
        }catch (SQLException E)
        {
            System.out.println(E);
        }
    }
    public void pincodeRigester(DeliveryBoyDetail deliveryBoyDetail)
    {
        pincodeService.pincodeRegister(deliveryBoyDetail);
    }

    public void rigesterDeliveryBoyPincode(DeliveryBoyDetail deliveryBoyDetail)
    {
        deliveryBoyPincodeServices.rigesterDeliveryBoyPincode(deliveryBoyDetail);
    }
}
