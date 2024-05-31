package seminar02_20240529.code.cinema;

import seminar02_20240529.code.cinema.interfaces.User;

public abstract class Users implements User {
    private String name;
    private String role;

    public Users(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
