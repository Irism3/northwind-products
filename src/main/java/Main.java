import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root", "1022Bella" );

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products;");

        while (resultSet.next()) {
            int id = resultSet.getInt("ProductID");
            String name = resultSet.getString("ProductName");
            double price = resultSet.getDouble("UnitPrice");
            int stock = resultSet.getInt("UnitsInStock");

            System.out.println("Product Id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Price: $" + String.format("%.2f", price));
            System.out.println("Stock: " + stock);
            System.out.println("------------------------");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
