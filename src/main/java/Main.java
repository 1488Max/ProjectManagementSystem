import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionToDB.getConnection();

        ProjectCrudService projectCrudService = new ProjectCrudService(connection);
        System.out.println("Sum of salary of all devs in certain project");
        projectCrudService.getSumOfSalaryByProjectID(1);
        System.out.println("List of devs in certain project");
        projectCrudService.getDeveloperByProject(1);
        DeveloperCrudService developerCrudService = new DeveloperCrudService(connection);
        System.out.println("Name of all Java Devs");
        developerCrudService.getJavaDevelopers();
        System.out.println("Name of middle devs");
        developerCrudService.getMiddleDevelopers();
        System.out.println("List of all projects in certain format");
        projectCrudService.getAllProjects();


    }
}
