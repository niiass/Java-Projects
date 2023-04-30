package methods;

import models.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Dao {
    Connection connection = null;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/console_app", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUser() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet rs = connection.createStatement().executeQuery("select * from users");
        while (rs.next()) {
            users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getInt(4), rs.getString(5), rs.getString(6),
                    UserType.valueOf(rs.getString(7))));
        }
        return users;
    }

    public List<User> getStudents() throws SQLException {
        List<User> students = new ArrayList<>();
        for (int i = 0; i < getUser().size(); i++) {
            if (getUser().get(i).getType().toString().equals("STUDENT")) {
                students.add(getUser().get(i));
            }
        }
        return students;
    }

    public List<User> getProfessors() throws SQLException {
        List<User> professors = new ArrayList<>();
        for (int i = 0; i < getUser().size(); i++) {
            if (getUser().get(i).getType().toString().equals("PROFESSOR")) {
                professors.add(getUser().get(i));
            }
        }
        return professors;
    }

    public List<Course> getCourse() throws SQLException {
        List<Course> courses = new ArrayList<>();
        ResultSet rs = connection.createStatement().executeQuery("select * from course");
        while (rs.next()) {
            courses.add(new Course(rs.getString(1), rs.getInt(2), rs.getBoolean(3), rs.getInt(4), rs.getInt(5)));
        }
        return courses;
    }

    public List<Enrollment> getEnrollment() throws SQLException {
        List<Enrollment> enrolls = new ArrayList<>();
        ResultSet rs = connection.createStatement().executeQuery("select * from enrollment");
        while (rs.next()) {
            enrolls.add(new Enrollment(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                    rs.getInt(4)));
        }
        return enrolls;
    }

    public List<Scores> getScores() throws SQLException {
        List<Scores> scores = new ArrayList<>();
        ResultSet rs = connection.createStatement().executeQuery("select * from scores");
        while (rs.next()) {
            scores.add(new Scores(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                    rs.getInt(4), rs.getInt(5)));
        }
        return scores;
    }
}