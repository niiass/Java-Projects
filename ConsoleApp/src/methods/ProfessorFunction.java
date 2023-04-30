package methods;

import main.Main;

import javax.swing.plaf.IconUIResource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorFunction {
    private static final Scanner s = new Scanner(System.in);
    Dao d = new Dao();
    Main main = new Main();

    Connection connection = null;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/console_app", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private int professorid;
    public void myClasses(String username, String password) throws SQLException {
        System.out.println("Your courses:"); professorid = 0;
        for (int i = 0; i < main.users.size(); i++) {
            if (main.users.get(i).getUsername().equals(username) && main.users.get(i).getPassword().equals(password)) {
                professorid = main.users.get(i).getId();
            }
        }
        for (int i = 0; i < main.courses.size(); i++) {
            if (main.courses.get(i).getProfessor_id() == professorid) {
                System.out.println((i+1) + ". " + main.courses.get(i).getCourse_name());
            }
        }
        System.out.println("Enter your action:" + '\n' + "1. Choose a course" + '\n' + "2. Go back");
        int action = s.nextInt();
        if (action == 1) {
            chooseCourse(username, password);
        } else if (action == 2) {
            action = 0;
        }
    }

    public void chooseCourse(String username, String password) {
        System.out.print("Enter course number: "); int number = s.nextInt();
        System.out.println("You have choosen " + main.courses.get(number-1).getCourse_name());
        System.out.println("What is your next action:" + '\n' + "1. Students list" + '\n' + "2. Go back");
        List<Integer> studentsids = new ArrayList<>();
        for (int i = 0; i < main.enrollments.size(); i++) {
            if (main.enrollments.get(i).getProfessorID() == professorid) {
                studentsids.add(main.enrollments.get(i).getStudentID());
            }
        }
        for (int i = 0; i < main.students.size(); i++) {
            for (int j = 0; j < studentsids.size(); i++) {
                if (studentsids.get(j) == main.students.get(i).getId()) {
                    System.out.println(main.students.get(i).getFirst_name() + " " + main.students.get(i).getLast_name());
                }
            }
        }
    }
}
