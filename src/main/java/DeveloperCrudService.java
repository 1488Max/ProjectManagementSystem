import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperCrudService {
    private PreparedStatement createSt;
    private PreparedStatement readSt;
    private PreparedStatement getDevByTechnology;
    private PreparedStatement getDevBySKill;

    public DeveloperCrudService(Connection connection) throws SQLException {
        try {
            createSt = connection
                    .prepareStatement("INSERT INTO developer (name, sex, salary) VALUES (?, ?, ?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            readSt = connection
                    .prepareStatement("SELECT id, name, sex, salary FROM developer WHERE id = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getDevByTechnology = connection.prepareStatement("""
                                SELECT DEVELOPER.*
                                from DEVELOPER
                                         join DEVELOPER_SKILL on DEVELOPER.ID = DEVELOPER_SKILL.DEVELOPER_ID
                                         join SKILL  on DEVELOPER_SKILL.SKILL_ID = SKILL.ID
                                where SKILL.TECHNOLOGY = ?
                """);
        getDevBySKill = connection.prepareStatement("""
                                SELECT DEVELOPER.*
                                from DEVELOPER
                                         join DEVELOPER_SKILL on DEVELOPER.ID = DEVELOPER_SKILL.DEVELOPER_ID
                                         join SKILL  on DEVELOPER_SKILL.SKILL_ID = SKILL.ID
                                where SKILL.SKILL = ?
                """);
    }

    public void create(Developer developer) throws SQLException {
        createSt.setString(1, developer.getName());
        createSt.setString(2, developer.getSex());
        createSt.setLong(3, developer.getSalary());

        createSt.executeUpdate();
    }

    public void getJavaDevelopers() throws SQLException {
        getDevByTechnology.setString(1, "Java");
        ResultSet resultSet = getDevByTechnology.executeQuery();
        while (resultSet.next()) {
            System.out.println("Name = " + resultSet.getString("Name"));

        }
    }
    public void getMiddleDevelopers() throws SQLException {
        getDevBySKill.setString(1, "Middle");
        ResultSet resultSet = getDevBySKill.executeQuery();
        while (resultSet.next()) {
            System.out.println("Name = " +  resultSet.getString("Name"));

        }
    }


    public Developer getById(long id) throws SQLException {
        readSt.setLong(1, id);

        ResultSet rs = readSt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        String name = rs.getString("name");
        String sex = rs.getString("sex");
        int salary = rs.getInt("salary");

        Developer result = new Developer(name, sex, salary);
        result.setID(id);

        return result;
    }

}