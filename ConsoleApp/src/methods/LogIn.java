package methods;

import main.*;
import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LogIn {
    private static final Scanner s = new Scanner(System.in);
    Connection connection = null;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/console_app", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    Dao d = new Dao();

    public User logIn(String username, String password) throws SQLException {
        Scanner s = new Scanner(System.in); int user_id = 0, user_i = -1;
        Main main = new Main();
        for (int i = 0; i < main.users.size(); i++) {
            if (main.users.get(i).getUsername().equals(username) && main.users.get(i).getPassword().equals(password)) {
                user_id = main.users.get(i).getId();
                user_i = i;
            }
        }
        if (user_id == 0 || user_i == -1) {
            System.out.println("Mismatch");
        }
        return new User(user_id, main.users.get(user_i).getFirst_name(), main.users.get(user_i).getLast_name(),
                main.users.get(user_i).getSemester(), main.users.get(user_i).getUsername(),
                main.users.get(user_i).getPassword(), UserType.valueOf((main.users.get(user_i).getType()).toString()));
    }
    AdminFunction af = new AdminFunction();
    StudentFuction sf = new StudentFuction();
    ProfessorFunction pf = new ProfessorFunction();
    public void isAdmin() throws SQLException {
        System.out.println("You have entered as an Admin.");
        System.out.println("Please enter your action:" + '\n' +"1. All courses" + '\n' +
                "2. Register student" + '\n' + "3. Register professor" + '\n' + "4. Log out");
        int ch = s.nextInt();
        if (ch == 1) {
            af.allCourses();
            isAdmin();
        } else if (ch == 2) {
            af.register(true);
            isAdmin();
        } else if (ch == 3) {
            af.register(false);
            isAdmin();
        } else if (ch == 4) {
            ch = 0;
        }
    }

    public void isStudent(String username, String password) throws SQLException {
        System.out.println("Welcome student" + '\n' + "Please enter your action:" + '\n' +
                "1. My classes" + '\n' + "2. Enroll in a class" + '\n' + "3. Log out");
        int ch = s.nextInt();
        if (ch == 1) {
            sf.myClasses(username, password);
            ch = 0;
        } else if (ch == 2) {
            sf.enrollInClass(username, password);
        } else if (ch == 3) {
            ch = 0;
        }
    }

    public void isProfessor(String username, String password) throws SQLException {
        System.out.println("Welcome Professor" + '\n' + "1. My classes" + '\n' + "2. Log out");
        int ch = s.nextInt();
        if (ch == 1) {
            pf.myClasses(username, password);
            isProfessor(username, password);
        } else if (ch == 2) {
            ch = 0;
        }
    }
}