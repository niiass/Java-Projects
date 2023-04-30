package models;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private int semester;
    private String username;
    private String password;
    private UserType type;

    public User() { }

    public User(int id, String first_name, String last_name, int semester, String username, String password, UserType type) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.semester = semester;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String first_name, String last_name, int semester, String username, String password, UserType type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.semester = semester;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String first_name, String last_name, String username, String password, UserType type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
