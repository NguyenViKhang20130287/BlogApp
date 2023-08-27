package Entity;

public class User {
    private int id;
    private String email;
    private String password;
    private int role_id;

    private int count;
    private int is_locked;

    public User() {
    }

    public User(int id, String email, String password, int role_id, int count, int is_locked) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return id + " " +
                email + " " +
                password + " " +
                role_id + " " +
                count + " " +
                is_locked;
    }
}
