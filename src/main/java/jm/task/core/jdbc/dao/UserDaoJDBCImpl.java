package jm.task.core.jdbc.dao;

import com.mysql.jdbc.Driver;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {
//        statement.execute("INSERT INTO public.people(name, age, mail) VALUES ('Ivan', 27, 'ivan@mail.ru');");

    }

    public void createUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate("CREATE TABLE user  (ID INT NOT NULL AUTO_INCREMENT, name VARCHAR(60) NOT NULL, last_name VARCHAR(40) NOT NULL, Age INT, PRIMARY KEY (id));");
        } catch (SQLException e) {
            //   e.printStackTrace();
            System.out.println("Не удалось создать таблицу пользователей");
        }
    }

    public void dropUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate("DROP TABLE user");
        } catch (SQLException e) {
            //    e.printStackTrace();
            System.out.println("Не удалось удалить таблицу пользователей");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(
                "INSERT INTO user (name, last_name, age) VALUES (?,?,?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //   e.printStackTrace();
            System.out.println("Ошибка сохранения пользователя");
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(
                "delete from user where id=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //   e.printStackTrace();
            System.out.println("Ошибка удаления пользователя");
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        try (Statement statement = Util.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM newdb.user;")) {
            while (resultSet.next()) {
                User user = new User(resultSet.getLong("id"),resultSet.getString("name"),resultSet.getString("last_name"),  resultSet.getByte("age"));
                userList.add(user);
            }
        } catch (Exception e) {
            //    e.printStackTrace();
            System.out.println("ошибка получения данных из таблицы");
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate("TRUNCATE user");
        } catch (SQLException e) {
            //  e.printStackTrace();
            System.out.println("Не удалить все записи из таблицы");
        }
    }
}

