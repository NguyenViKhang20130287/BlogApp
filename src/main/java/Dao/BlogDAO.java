package Dao;

import DB.DBConnect;
import Entity.Blog;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {

    Statement statement;
    PreparedStatement ps;
    ResultSet rs;

    public List<Blog> getAllBlog() {
        List<Blog> listBlog = new ArrayList<>();
        String query = "SELECT\n" +
                "\tblog.id,\n" +
                "\tblog.title,\n" +
                "\tblog.content,\n" +
                "\tblog.createAt,\n" +
                "\tblog.updateAt,\n" +
                "\t`user`.email \n" +
                "FROM\n" +
                "\t`blog`\n" +
                "\tJOIN blogs ON blog.id = blogs.blog_id\n" +
                "\tJOIN `user` ON `user`.id = blogs.user_id \n" +
                "GROUP BY\n" +
                "\tblog.id,\n" +
                "\tblog.title,\n" +
                "\tblog.content,\n" +
                "\tblog.createAt,\n" +
                "\tblog.updateAt,\n" +
                "\t`user`.email";

        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Blog b = new Blog();
                    b.setId(rs.getInt(1));
                    b.setTitle(rs.getString(2));
                    b.setContent(rs.getString(3));
                    b.setCreateAt(rs.getString(4));
                    b.setUpdateAt(rs.getString(5));
                    b.setEmail(rs.getString(6));
                    listBlog.add(b);
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listBlog;
    }

    public void postBlog(String title, String content, int user_id) {
        String query_1 = "INSERT INTO blog (blog.title, blog.content, blog.createAt, blog.updateAt) VALUES (?, ?, ?, ?)";
        String query_2 = "INSERT INTO blogs (blogs.blog_id, blogs.user_id) VALUES (?, ?)";
        String query_3 = "SELECT MAX(blog.id) FROM blog";

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(dateTimeFormatter);

        int blog_id = 0;
        try {
            statement = DBConnect.getInstall().get();
            if (statement != null) {
                ps = new DBConnect().getConnection().prepareStatement(query_1);
                ps.setString(1, title);
                ps.setString(2, content);
                ps.setString(3, String.valueOf(LocalDateTime.now()));
                ps.setString(4, String.valueOf(LocalDateTime.now()));
                ps.executeUpdate();

                PreparedStatement ps_2 = new DBConnect().getConnection().prepareStatement(query_2);
                PreparedStatement ps_3 = new DBConnect().getConnection().prepareStatement(query_3);
                rs = ps_3.executeQuery();
                while (rs.next()) {
                    blog_id = rs.getInt(1);
                }

                ps_2.setInt(1, blog_id);
                ps_2.setInt(2, user_id);
                ps_2.executeUpdate();

                ps.close();
                rs.close();
                ps_3.close();
                ps_2.close();

                System.out.println("POST BLOG SUCCESSFULLY ^^");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new BlogDAO().getAllBlog());
        new BlogDAO().postBlog("title datetime", "content1 datetime", 3);
    }

}
