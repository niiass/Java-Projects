package main;

import methods.AdminFunction;
import methods.Dao;

import java.sql.DriverManager;

import methods.*;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class Main {
    private static final Scanner s = new Scanner(System.in);
    public static boolean stay = true;
    Dao d = new Dao();
    public List<User> users = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();
    public List<User> students = new ArrayList<>();
    public List<User> professors = new ArrayList<>();
    public List<Enrollment> enrollments = new ArrayList<>();
    public List<Scores> scores = new ArrayList<>();
    {
        try {
            users = d.getUser();
            courses = d.getCourse();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getType().getName().equals("STUDENT")) {
                    students.add(users.get(i));
                }
                if (users.get(i).getType().toString().equals("PROFESSOR")) {
                    professors.add(users.get(i));
                }
            }
            enrollments = d.getEnrollment();
            scores = d.getScores();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        LogIn li = new LogIn();
        while (stay) {
            int choice = 1;
            while (choice == 1) {
                System.out.println("Welcome to university portal" + '\n' + "Actions:" + '\n' + "1. Log In" + '\n' + "2. Exit");
                choice = s.nextInt();
                if (choice == 2) {
                    break;
                }

                System.out.print("username: "); String username = s.next();
                System.out.print("password: "); String password = s.next();
                if (li.logIn(username, password).getType().toString().equals("ADMINISTRATION")) {
                    li.isAdmin();
                } else if (li.logIn(username, password).getType().toString().equals("STUDENT")) {
                    li.isStudent(username, password);
                } else if (li.logIn(username, password).getType().toString().equals("STUDENT")) {
                    li.isProfessor(username, password);
                }
            }
            if (choice == 2) {
                stay = false;
            }
        }
    }
}