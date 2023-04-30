package models;

public enum UserType {
    ADMINISTRATION("ADMINISTRATION"),
    STUDENT("STUDENT"),
    PROFESSOR("PROFESSOR");

    private final String name;

    private UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
