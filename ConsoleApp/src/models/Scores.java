package models;

public class Scores {
    private int professor_id;
    private int student_id;
    private int course_id;
    private int score;
    private int id;

    public Scores(int professor_id, int student_id, int course_id, int score, int id) {
        this.professor_id = professor_id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.score = score;
        this.id = id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
