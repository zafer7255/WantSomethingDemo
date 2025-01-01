package DeliveryBoy.DatabaseSaved;
import DeliveryBoy.Model.DeliveryBoyDetail;

import java.sql.*;

public class DeliveryBoySaved {

    private static final String URL = "jdbc:mysql://localhost:3306/wantsomething";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Zafer6231@";

    public void DeliveryBoyDetailSave(String name,String education,int age,String address,String panNo,int boyid) throws SQLException {
        String insertSQL = "INSERT INTO deliveryboydetail (name,education,age,address,pancard,boyid) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, education);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, panNo);
            preparedStatement.setInt(6, boyid);
            preparedStatement.executeUpdate();
            System.out.println("Delivery boy data saved successfully!");
        }catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Done");
        }
    }
    public synchronized void InsertUniquePincode(int pincode)
    {
        String insertSQL = "INSERT IGNORE INTO allpincode (pincode) VALUES (?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setInt(1, pincode);
            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Done1");
        }

    }

public synchronized void DeliveryBoyPincode(int id , int pincode)
{
    /*String insertSQL = "INSERT INTO delivery_boy_pincode (deliveryBoyID, pincode) VALUES (?, ?)";
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

        System.out.println(id);
        System.out.println(pincode);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, pincode);
        preparedStatement.executeUpdate();
        throw new SQLIntegrityConstraintViolationException("You already write this pincode : - " + pincode);
    }catch (SQLIntegrityConstraintViolationException e)
    {
        System.out.println(e);
    }
    catch (SQLException e)
    {
        e.printStackTrace();
        System.out.println("Done2");
    }*/
    String checkSQL = "SELECT COUNT(*) FROM delivery_boy_pincode WHERE deliveryBoyID = ? AND pincode = ?";
    String insertSQL = "INSERT INTO delivery_boy_pincode (deliveryBoyID, pincode) VALUES (?, ?)";

    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
        // Check if the same deliveryBoyID already wrote this pincode
        try (PreparedStatement checkStatement = connection.prepareStatement(checkSQL)) {
            checkStatement.setInt(1, id);
            checkStatement.setInt(2, pincode);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    throw new SQLIntegrityConstraintViolationException(
                            "DeliveryBoyID " + id + " has already written pincode: " + pincode
                    );
                }
            }
        }

        // Insert into the database
        try (PreparedStatement insertStatement = connection.prepareStatement(insertSQL)) {
            System.out.println("Inserting DeliveryBoyID: " + id + ", Pincode: " + pincode);
            insertStatement.setInt(1, id);
            insertStatement.setInt(2, pincode);
            insertStatement.executeUpdate();
            System.out.println("Insert successful!");
        }
    } catch (SQLIntegrityConstraintViolationException e) {
        System.out.println(e.getMessage());
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Database operation failed.");
    }

}
}
