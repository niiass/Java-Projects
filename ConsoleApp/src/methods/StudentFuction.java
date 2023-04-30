package methods;

import main.Main;
import models.Course;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFuction {
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

    public User student(String username, String password) {
        User user = new User();
        for (int i = 0; i < main.students.size(); i++) {
            if (main.students.get(i).getUsername().equals(username) && main.students.get(i).getPassword().equals(password)) {
                user = main.students.get(i);
            }
        }
        return user;
    }
    public void myClasses(String username, String password) throws SQLException {
        for (int i = 0; i < main.enrollments.size(); i++) {
            if (main.enrollments.get(i).getStudentID() == student(username, password).getId()) {
                int courseid = main.enrollments.get(i).getCourseID();
                for (int j = 0; j < main.courses.size(); j++) {
                    if (main.courses.get(j).getCourse_id() == courseid) {
                        System.out.println(main.courses.get(j).getCourse_name());
                    }
                }
            }
        }
        System.out.println("Enter your action:" + '\n' + "1. My grades" + '\n' + "2. Go back");
        int action = s.nextInt();
        if (action == 1) {
            System.out.print("Please enter course number: "); int number = s.nextInt();
            double sum = 0, gpa = 0;
            for (int i = 0; i < main.scores.size(); i++) {
                if (main.scores.get(i).getStudent_id() == student(username, password).getId() &&
                        main.scores.get(i).getCourse_id() == number) {
                    System.out.println(main.scores.get(i).getScore() + " ");
                    sum += main.scores.get(i).getScore();
                    gpa++;
                }
            }
            System.out.println(sum/gpa);
        } else if (action == 2) {
            LogIn li = new LogIn();
            li.isStudent(username, password);
        }
    }

    public void enrollInClass(String username, String password) throws SQLException {
        List<Course> optional = new ArrayList<>(); int index = 1, courseid = 0, coursesemester = 0, professorid = 0;
        for (int i = 0; i < main.courses.size(); i++) {
            if (main.courses.get(i).isCourse_isOptional()) {
                optional.add(main.courses.get(i));
                System.out.println((index++) + " " + main.courses.get(i).getCourse_name());
            }
        }
        System.out.print("Please enter course number: "); int number = s.nextInt();
        for (int i = 0; i < optional.size(); i++) {
            if ((i+1) == number) {
                courseid = optional.get(i).getCourse_id();
                professorid = optional.get(i).getProfessor_id();
                coursesemester = optional.get(i).getCourse_semester();
            }
        }
        for (int i = 0; i < main.enrollments.size(); i++) {
            if (main.enrollments.get(i).getCourseID() == courseid) {
                System.out.println("You are already taking this class!");
            } else if (!(main.enrollments.get(i).getCourseID() == courseid) &&
                    student(username, password).getSemester() != coursesemester) {
                System.out.println("This class is supposed to be taken in " + coursesemester + " semester");
            } else {
                PreparedStatement ps = connection.prepareStatement("insert into enrollment(student_id, course_id, " +
                        "professor_id) values (?, ?, ?)");
                ps.setInt(1, student(username, password).getId());
                ps.setInt(2, courseid); ps.setInt(3, professorid);
                ps.executeUpdate();
                System.out.println("You are added to a course");
            }
        }
    }
}
