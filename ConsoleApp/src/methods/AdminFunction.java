package methods;

import models.*;
import main.*;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminFunction {
    Dao d = new Dao();
    Main main = new Main();
    List<Course> courses = main.courses;
    List<User> students = main.students;
    Connection connection = null;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/console_app", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String register = "insert into users values(?,?,?,?,?)";
    private static final String edit = "update course set course_name = ?, course_semester = ?, " +
            "course_isoptional = ? where id = ?";
    private static final Scanner s = new Scanner(System.in);

    public void getAllCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i+1) + ". " + courses.get(i).getCourse_name());
        }
    }

    public void addCourse() throws SQLException {
        System.out.print("Course name: "); String name = s.next();
        System.out.print("Course semester: "); int semester = s.nextInt();
        System.out.print("Course optionality: "); boolean isOptional = s.nextBoolean();
        List<User> users = d.getUser(), professors = main.professors;
        System.out.println("Choose a professor number to assign to a course:");
        for (int i = 0; i < professors.size(); i++) {
            System.out.println((i+1) + ". " + professors.get(i).getFirst_name() + " " + professors.get(i).getLast_name());
        }
        int num = s.nextInt(), professorID = professors.get(num-1).getId();
        PreparedStatement ps = connection.prepareStatement("insert into course(course_name, course_semester, " +
                "course_isoptional, professor_id) values(?, ?, ?, ?)");
        ps.setString(1, name); ps.setInt(2, semester);
        ps.setBoolean(3, isOptional); ps.setInt(4, professorID);
        ps.executeUpdate();
        main.courses.add(new Course(name, semester, isOptional, professorID));
        System.out.println("Course added" + '\n');
    }

    public void editCourse() throws SQLException {
        getAllCourses();
        System.out.print("Choose a course number: "); int num = s.nextInt();
        String editedname = null; int editedsemester = 0, courseid = 0; boolean editedoptionality = true;
        for (int i = 0; i < courses.size(); i++) {
            if ((i+1) == num) {
                courseid = courses.get(i).getCourse_id();
                System.out.println("Selected: " + courses.get(i).getCourse_name() + '\n' + "Enter values to update");
                System.out.print("Edited name: "); editedname = s.next();
                System.out.print("Edited semester: "); editedsemester = s.nextInt();
                System.out.println("Edited optionality: "); editedoptionality = s.nextBoolean();
                PreparedStatement ps = connection.prepareStatement(edit);
                ps.setString(1, editedname); ps.setInt(2, editedsemester);
                ps.setBoolean(3, editedoptionality); ps.setInt(4, courseid);
                ps.executeUpdate();
                System.out.println("Course edited" + '\n');
            }
        }
    }

    public void deleteCourse() throws SQLException {
        getAllCourses();
        System.out.print("Choose a course number: "); int num = s.nextInt(), courseid = 0;
        for (int i = 0; i < courses.size(); i++) {
            if ((i+1) == num) {
                courseid = courses.get(i).getCourse_id();
                courses.remove(i);
            }
        }
        System.out.println(courseid);
        PreparedStatement ps = connection.prepareStatement("delete from course where course_id = ?;");
        ps.setInt(1, courseid); ps.executeUpdate();
        System.out.println("Course deleted" + '\n');
    }

    public void addStudentToCourse() throws SQLException {
        getAllCourses();
        System.out.print("Choose a course number: "); int num = s.nextInt();
        int courseid = 0, studentid = 0, professorid = 0;
        for (int i = 0; i < courses.size(); i++) {
            if ((i + 1) == num) {
                System.out.println("You have selected " + courses.get(i).getCourse_name());
                courseid = courses.get(i).getCourse_id();
                professorid = courses.get(i).getProfessor_id();
            }
        }
        System.out.println("Which student should be added:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getFirst_name() + " " + students.get(i).getLast_name());
        }
        int addstud = s.nextInt();
        if (students.get(addstud - 1).getSemester() != courses.get(num - 1).getCourse_semester()) {
            System.out.println("Student can't be added to that course");
        } else {
            System.out.println("You have selected the following student: " + students.get(addstud - 1).getFirst_name()
                    + " " + students.get(addstud - 1).getLast_name());
            studentid = students.get(addstud - 1).getId();
            PreparedStatement ps = connection.prepareStatement("insert into enrollment(student_id, course_id, " +
                    "professor_id) values(?, ?, ?);");
            ps.setInt(1, studentid); ps.setInt(2, courseid);
            ps.setInt(3, professorid); ps.executeUpdate();
            System.out.println("Student is added to the course" + '\n');
            main.enrollments.add(new Enrollment(studentid, courseid, professorid));
        }
    }

    public void assignProfessor() throws SQLException {
        getAllCourses();
        System.out.print("Choose a course number: "); int num = s.nextInt(), courseid = 0;
        for (int i = 0; i < courses.size(); i++) {
            if ((i+1) == num) {
                System.out.println("You have chosen " + courses.get(i).getCourse_name());
                courseid = courses.get(i).getCourse_id();
            }
        }
        System.out.println("Which professor do you want to assign this course to? (Choose a number)");
        int choose, professorid = 0;
        for (int i = 0; i < main.professors.size(); i++) {
            System.out.println((i+1) + ". " + main.professors.get(i).getFirst_name() + " " +
                    main.professors.get(i).getLast_name());
        }
        choose = s.nextInt();
        professorid = main.professors.get(choose-1).getId();
        PreparedStatement ps = connection.prepareStatement("update course set professor_id = ? where course_id = ?");
        ps.setInt(1, professorid); ps.setInt(2, courseid); ps.executeUpdate();
        System.out.println("Professor assigned" + '\n');
    }

    public void allCourses() throws SQLException {
        for (int i = 0; i < main.courses.size(); i++) {
            System.out.println((i+1) + ". " + main.courses.get(i).getCourse_name());

        }
        System.out.println('\n' + "Enter your action:" + '\n' + "1. Add a new course" + '\n' +
                    "2. Edit course" + '\n' + "3. Delete course" + '\n' + "4. Add a student to course" + '\n' +
                    "5. Assign professor" + '\n' + "6. Go back");
        int choice = s.nextInt();
        if (choice == 1) {
            addCourse();
        } else if (choice == 2) {
            editCourse();
        } else if (choice == 3) {
            deleteCourse();
        } else if (choice == 4) {
            addStudentToCourse();
        } else if (choice == 5) {
            assignProfessor();
        } else if (choice == 6) {
            choice = 0;
        }
    }

    public void register(boolean studOrProf) throws SQLException {
        System.out.print("Enter name: "); String name = s.next();
        System.out.print("Enter last name: "); String lastName = s.next();;
        System.out.print("Enter username: "); String username = s.next();
        System.out.print("Enter password: "); String password = s.next();
        PreparedStatement ps = connection.prepareStatement("insert into Users(first_name, last_name, semester, " +
                "username, password, type) values(?, ?, ?, ?, ?, ?);");
        ps.setString(1, name);
        ps.setString(2, lastName);
        ps.setString(4, username);
        ps.setString(5, password);
        if (studOrProf) {
            System.out.print("Enter semester: "); int studSemester = s.nextInt();
            User student = new User(name, lastName, studSemester, username, password, UserType.STUDENT);
            main.users.add(student);
            ps.setInt(3, studSemester);
            ps.setString(6, UserType.STUDENT.getName());
            ps.executeUpdate();
            System.out.println("Student added" + '\n');
            main.students.add(new User(name, lastName, studSemester, username, password, UserType.STUDENT));
        } else {
            User professor = new User(name, lastName, username, password, UserType.PROFESSOR);
            main.users.add(professor);
            ps.setNull(3, Types.INTEGER);
            ps.setString(6, UserType.PROFESSOR.getName());
            ps.executeUpdate();
            System.out.println("Professor added" + '\n');
            main.professors.add(new User(name, lastName, username, password, UserType.PROFESSOR));
        }
    }
}