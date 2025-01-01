package DeliveryBoy.Model;

import DeliveryBoy.DatabaseSaved.DeliveryBoySaved;

import javax.management.ConstructorParameters;
import java.util.List;

public class DeliveryBoyDetail {
    private static int id = 0;
    private String name;
    private String education;
    private int age;
    private String address;
    private String panNumber;
    private List<Integer> allPincode;
    public DeliveryBoyDetail(String address, String panNumber, int age, String education, String name , List<Integer> allPincode) {
        id++;
        this.address = address;
        this.panNumber = panNumber;
        this.age = age;
        this.education = education;
        this.name = name;
        this.allPincode = allPincode;
    }

    public int getId() {
        return id;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getEducation() {
        return education;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getAllPincode() {
        return allPincode;
    }
}
