import DeliveryBoy.Controller.DeliveryBoyController;
import DeliveryBoy.Model.DeliveryBoyDetail;
import DeliveryBoy.Service.PincodeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer>pincodeArray = new ArrayList<>();
        int number_of_pincode;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("How many pincode you want to enter ");
        number_of_pincode = Integer.parseInt(reader.readLine());
        for (int i = 1 ; i <= number_of_pincode; i++)
        {
            System.out.println("Enter the " + i +"th number ");
            int each_number = Integer.parseInt(reader.readLine());
            pincodeArray.add(each_number);
        }
        System.out.println(number_of_pincode);
        DeliveryBoyController deliveryBoyController = new DeliveryBoyController();
        DeliveryBoyDetail deliveryBoy1Detail = new DeliveryBoyDetail("Deori Kala Gola par ","HSV321",19,"Bachlor's","Zafer",pincodeArray);
        deliveryBoyController.rigesterDelhiveryBoy(deliveryBoy1Detail);
        deliveryBoyController.pincodeRigester(deliveryBoy1Detail);
        deliveryBoyController.rigesterDeliveryBoyPincode(deliveryBoy1Detail);

    }
}