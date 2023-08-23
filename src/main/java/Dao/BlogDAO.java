package Dao;

import DB.DBConnect;
import Entity.Blog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public static void main(String[] args) {
        System.out.println(new BlogDAO().getAllBlog());
    }

}
