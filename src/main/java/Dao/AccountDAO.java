package Dao;

import DB.DBConnect;
import Entity.Blog;
import Entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    Statement statement;
    PreparedStatement ps;
    ResultSet rs;

    // check email exists
    public User checkEmailIsExist(String email) {
        String query = "SELECT * FROM `user` WHERE email = ?";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setString(1, email);
                rs = ps.executeQuery();
                while (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt(1));
                    u.setEmail(rs.getString(2));
                    u.setPassword(rs.getString(3));
                    u.setRole_id(rs.getInt(4));
                    u.setCount(rs.getInt(5));
                    u.setIs_locked(rs.getInt(6));
                    return u;
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // sign up account
    public void signUpAccount(String email, String password) {
        String query = "INSERT INTO `user`(`user`.email, `user`.`password`, `user`.role_id, `user`.is_locked) " +
                "VALUES (?, ?, ?, ?)";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setString(1, email);
                ps.setString(2, password);
                ps.setInt(3, 1);
                ps.setInt(4, 0);
                ps.executeUpdate();
                System.out.println("Sign up successfully ^^");

                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // sign in account
    public User signInAccount(String email, String password) {
        User u = new User();
        String query = "SELECT * FROM `user` WHERE `user`.email = ? AND `user`.`password` = ?";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setString(1, email);
                ps.setString(2, password);
                rs = ps.executeQuery();
                while (rs.next()) {
                    u.setId(rs.getInt(1));
                    u.setEmail(rs.getString(2));
                    u.setPassword(rs.getString(3));
                    u.setRole_id(rs.getInt(4));
                    u.setCount(rs.getInt(5));
                    u.setIs_locked(rs.getInt(6));
                    return u;
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // change password
    public void changePassword(String email, String newPassword) {
        String query = "UPDATE `user` SET `user`.`password` = ? WHERE `user`.email = ?";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setString(2, email);
                ps.setString(1, newPassword);
                ps.executeUpdate();
                System.out.println("Change password successfully ^^");

                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // get all user
    public List<User> getAllUser() {
        List<User> listUser = new ArrayList<>();
        String query = "SELECT * FROM `user`";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt(1));
                    u.setEmail(rs.getString(2));
                    u.setPassword(rs.getString(3));
                    u.setRole_id(rs.getInt(4));
                    u.setCount(rs.getInt(5));
                    u.setIs_locked(rs.getInt(6));
                    listUser.add(u);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUser;
    }

    // lock acc
    public void lockAcc(String email) {
        String query = "UPDATE `user` SET `user`.is_locked = 1 WHERE `user`.email = ?";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setString(1, email);
                ps.executeUpdate();

                System.out.println("LockAcc successfully !!");
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void lockAccWithId(int user_id) {
        String query = "UPDATE `user` SET `user`.is_locked = 1 WHERE `user`.id = ?";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setInt(1, user_id);
                ps.executeUpdate();

                System.out.println("LockAcc successfully !!");
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void upCount(String email) {
        String query = "UPDATE `user` SET `user`.count = `user`.count + 1 WHERE `user`.email = ?";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setString(1, email);
                ps.executeUpdate();

                System.out.println("upCount successfully !!");
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void resetCount(String email) {
        String query = "UPDATE `user` SET `user`.count = 0 WHERE `user`.email = ?";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setString(1, email);
                ps.executeUpdate();

                System.out.println("Reset count successfully !!");
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void resetCountWithID(int user_id) {
        String query = "UPDATE `user` SET `user`.count = 0 WHERE `user`.id = ?";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setInt(1, user_id);
                ps.executeUpdate();

                System.out.println("Reset count successfully !!");
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // delete User
    public void deleteUser(int user_id) {
        String query_1 = "DELETE FROM blogs WHERE blogs.user_id = ?";
        String query_2 = "DELETE FROM `user` WHERE `user`.id = ?";
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query_1);
                ps.setInt(1, user_id);
                ps.executeUpdate();

                //
                PreparedStatement ps_2 = new DBConnect().getConnection().prepareStatement(query_2);
                ps_2.setInt(1, user_id);
                ps_2.executeUpdate();

                System.out.println("Delete user successfully ^^");
                ps.close();
                ps_2.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // unlock
    public void unLockAcc(int user_id){
        String query = "UPDATE `user` SET `user`.is_locked = 0 WHERE `user`.id = ?";
        try {
            statement = DBConnect.getInstall().get();
            if(statement != null){
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setInt(1, user_id);
                ps.executeUpdate();

                System.out.println("Unlock successfully ^^");
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        new AccountDAO().signUpAccount("k1@gmail.com", "11111111");
//        System.out.println(new AccountDAO().signInAccount("vik080817@gmail.com", "11111111"));
//        new AccountDAO().changePassword("vik080817@gmail.com", "11111111");
//        System.out.println(new AccountDAO().getAllUser());
        System.out.println(new AccountDAO().checkEmailIsExist("vik080817@gmail.com"));
    }

}
