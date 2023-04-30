package models;

public class Enrollment {
    private int studentID;
    private int courseID;
    private int professorID;
    private int enrollmentID;

    public Enrollment(int studentID, int courseID, int professorID, int enrollmentID) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.professorID = professorID;
        this.enrollmentID = enrollmentID;
    }

    public Enrollment(int studentID, int courseID, int professorID) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.professorID = professorID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }
}
