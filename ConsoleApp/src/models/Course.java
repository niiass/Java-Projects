package models;

public class Course {
    private String course_name;
    private int course_semester;
    private boolean course_isOptional;
    private int course_id;
    private int professor_id;

    public Course(String course_name, int course_semester, boolean course_isOptional, int professor_id) {
        this.course_name = course_name;
        this.course_semester = course_semester;
        this.course_isOptional = course_isOptional;
        this.professor_id = professor_id;
    }

    public Course(String course_name, int course_semester, boolean course_isOptional, int course_id, int professor_id) {
        this.course_name = course_name;
        this.course_semester = course_semester;
        this.course_isOptional = course_isOptional;
        this.course_id = course_id;
        this.professor_id = professor_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_semester() {
        return course_semester;
    }

    public boolean isCourse_isOptional() {
        return course_isOptional;
    }

    public void setCourse_isOptional(boolean course_isOptional) {
        this.course_isOptional = course_isOptional;
    }

    public void setCourse_semester(int course_semester) {
        this.course_semester = course_semester;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }
}
