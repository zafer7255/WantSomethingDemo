package DeliveryBoy.Service;

import DeliveryBoy.DatabaseSaved.DeliveryBoySaved;
import DeliveryBoy.Model.DeliveryBoyDetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryBoyService {
    private List<DeliveryBoyDetail> deliveryBoyDetailss = new ArrayList<>();
    private DeliveryBoySaved deliveryBoySaved = new DeliveryBoySaved();
    public void rigesterDeliveryBoy(DeliveryBoyDetail deliveryBoyDetail) throws SQLException {

        deliveryBoyDetailss.add(deliveryBoyDetail);
        System.out.println(deliveryBoyDetail.getName());
        deliveryBoySaved.DeliveryBoyDetailSave(deliveryBoyDetail.getName(),deliveryBoyDetail.getEducation(),deliveryBoyDetail.getAge(),deliveryBoyDetail.getAddress(),deliveryBoyDetail.getPanNumber(),deliveryBoyDetail.getId());
        //System.out.println("DeliveryBoy send to database saved file " + deliveryBoyDetail.getId());
    }
}
