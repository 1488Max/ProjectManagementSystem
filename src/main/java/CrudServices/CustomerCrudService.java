package CrudServices;

import Connection.ConnectionToDB;
import Entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerCrudService {
    static Connection connection = ConnectionToDB.getConnection();
    private static PreparedStatement createSt;
    private static PreparedStatement readSt;
    private static PreparedStatement updateSt;
    private static PreparedStatement deleteSt;


    static {
        try {
            createSt = connection
                    .prepareStatement("INSERT INTO CUSTOMER (name, SURNAME) VALUES (?, ?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            readSt = connection
                    .prepareStatement("SELECT id, name, surname FROM CUSTOMER WHERE id = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            updateSt = connection
                    .prepareStatement("UPDATE CUSTOMER SET customer.name = ? WHERE customer.id = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            deleteSt = connection.
                    prepareStatement("DELETE from customer WHERE id = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void create(Customer customer) throws SQLException {
        createSt.setString(1, customer.getName());
        createSt.setString(2, customer.getSurname());
        createSt.executeUpdate();
    }

    public static Customer getById(long id) throws SQLException {
        readSt.setLong(1, id);

        ResultSet rs = readSt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        String name = rs.getString("name");
        String surname = rs.getString("surname");


        Customer result = new Customer(name, surname);
        result.setID(id);

        return result;
    }

    public static void updateNameByID(long id, String inputInfo) throws SQLException {

        updateSt.setString(1, inputInfo);
        updateSt.setLong(2, id);

        updateSt.executeUpdate();
    }

    public static void deleteByID(long id) throws SQLException {
        deleteSt.setLong(1, id);

        deleteSt.executeUpdate();
    }

}