import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerCrudService {
    private PreparedStatement createSt;
    private PreparedStatement readSt;
    public CustomerCrudService(Connection connection) throws SQLException {

            createSt = connection
                    .prepareStatement("INSERT INTO CUSTOMER (name, SURNAME) VALUES (?, ?)");



            readSt = connection
                    .prepareStatement("SELECT id, name, surname FROM CUSTOMER WHERE id = ?");


    }

}