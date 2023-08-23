package Entity;

public class User {
    private int id;
    private String email;
    private String password;
    private int role_id;
    private int is_locked;

    public User() {
    }

    public User(int id, String email, String password, int role_id, int is_locked) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
        this.is_locked = is_locked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getIs_locked() {
        return is_locked;
    }

    public void setIs_locked(int is_locked) {
        this.is_locked = is_locked;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", role_id=" + role_id + ", is_locked=" + is_locked + '}';
    }
}
