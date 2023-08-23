package Dao;

import DB.DBConnect;
import Entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

    Statement statement;
    PreparedStatement ps;
    ResultSet rs;

    // check email exists
    public User checkEmailSignUpIsExist(String email) {
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
                    u.setIs_locked(rs.getInt(5));
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // sign in account
    public User signInAccount(String email, String password){
        User u = new User();
        String query = "SELECT * FROM `user` WHERE `user`.email = ? AND `user`.`password` = ?";
        try {
            statement = DBConnect.getInstall().get();
            if(statement != null){
                ps = new DBConnect().getConnection().prepareStatement(query);
                ps.setString(1, email);
                ps.setString(2, password);
                rs = ps.executeQuery();
                while (rs.next()){
                    u.setId(rs.getInt(1));
                    u.setEmail(rs.getString(2));
                    u.setPassword(rs.getString(3));
                    u.setRole_id(rs.getInt(4));
                    u.setIs_locked(rs.getInt(5));
                    return u;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
//        new AccountDAO().signUpAccount("k1@gmail.com", "11111111");
//        System.out.println(new AccountDAO().signInAccount("vik080817@gmail.com", "11111111"));
    }

}
