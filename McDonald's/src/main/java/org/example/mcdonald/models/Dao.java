package org.example.mcdonald.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    Connection connection = null;
    ResultSet rs = null;
    ResultSet rsCharity = null;
    PreparedStatement ps = null;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mcdonalds", "root", "password");
            rs = connection.createStatement().executeQuery("select * from products");
            rsCharity = connection.createStatement().executeQuery("select * from charity");
            ps = connection.prepareStatement("select * from products where type = ?");
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    public List<Products> getByType(String type) throws SQLException {
        List<Products> typeList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE type = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, type);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String category = resultSet.getString("type");
                    String name = resultSet.getString("name");
                    String image = resultSet.getString("img");

                    Products product = new Products(id, category, name, image);
                    typeList.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return typeList;
    }

    public List<Charity> getCharity() throws SQLException {
        List<Charity> charity = new ArrayList<>();
        while (rsCharity.next()) {
            charity.add(new Charity(rsCharity.getInt(2), rsCharity.getString(3), rsCharity.getString(4)));
        }
        return charity;
    }
}