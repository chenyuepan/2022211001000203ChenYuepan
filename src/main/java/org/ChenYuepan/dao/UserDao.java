package org.ChenYuepan.dao;

import org.ChenYuepan.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        PreparedStatement statement = con.prepareStatement("insert into usertable(username,u_password,email,gender,birth) values (?,?,?,?,?)");
        statement.setString(1,user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3,user.getEmail());
        statement.setString(4,user.getGender());
        statement.setString(5,user.getBirthDay());
        int i = statement.executeUpdate();
        if(i==1){
            return true;
        }
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        PreparedStatement statement = con.prepareStatement("delete from usertable where username=? and u_password=?");
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        return statement.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        PreparedStatement statement = con.prepareStatement("update usertable set email=?, gender=?, birth=? where username=? and u_password=?");
        statement.setString(1,user.getEmail());
        statement.setString(2,user.getGender());
        statement.setString(3,user.getBirthDay());
        statement.setString(4,user.getUsername());
        statement.setString(5, user.getPassword());
        return statement.executeUpdate();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from usertable where id= ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            User user=new User();
            user.setId(id);
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("u_password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDay(resultSet.getString("birth"));
            return user;
        }
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from usertable where username=? and u_password=?");
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("u_password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDay(resultSet.getString("birth"));
            return user;
        }
        return null;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from usertable where username=?");
        statement.setString(1,username);
        ResultSet resultSet = statement.executeQuery();
        List<User> users=new ArrayList<>();
        while (resultSet.next()){
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("u_password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDay(resultSet.getString("birth"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from usertable where u_password=?");
        statement.setString(1,password);
        ResultSet resultSet = statement.executeQuery();
        List<User> users=new ArrayList<>();
        while (resultSet.next()){
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("u_password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDay(resultSet.getString("birth"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from usertable where email=?");
        statement.setString(1,email);
        ResultSet resultSet = statement.executeQuery();
        List<User> users=new ArrayList<>();
        while (resultSet.next()){
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("u_password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDay(resultSet.getString("birth"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from usertable where gender=?");
        statement.setString(1,gender);
        ResultSet resultSet = statement.executeQuery();
        List<User> users=new ArrayList<>();
        while (resultSet.next()){
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("u_password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDay(resultSet.getString("birth"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from usertable where birth=?");
        statement.setString(1,birthDate.toString());
        ResultSet resultSet = statement.executeQuery();
        List<User> users=new ArrayList<>();
        while (resultSet.next()){
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("u_password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDay(resultSet.getString("birth"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        PreparedStatement statement = con.prepareStatement("select * from usertable");
        ResultSet resultSet = statement.executeQuery();
        List<User> users=new ArrayList<>();
        while (resultSet.next()){
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("u_password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDay(resultSet.getString("birth"));
            users.add(user);
        }
        return users;
    }
}
