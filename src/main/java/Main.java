import CrudServices.CustomerCrudService;
import CrudServices.DeveloperCrudService;
import CrudServices.ProjectCrudService;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {


        System.out.println("Sum of salary of all devs in certain project");

        ProjectCrudService.getSumOfSalaryByProjectID(1);

        System.out.println("List of devs in certain project");

        ProjectCrudService.getDeveloperByProject(1);


        System.out.println("Name of all Java Devs");

        DeveloperCrudService.getJavaDevelopers();

        System.out.println("Name of middle devs");

        DeveloperCrudService.getMiddleDevelopers();

        System.out.println("List of all projects in certain format");

        ProjectCrudService.getAllProjects();


        CustomerCrudService.updateNameByID(1, "Max");

    }
}
