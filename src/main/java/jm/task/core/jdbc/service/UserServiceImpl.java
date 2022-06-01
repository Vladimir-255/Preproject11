package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl daoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable() {
        daoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        daoJDBC.dropUsersTable();
    }
    public void saveUser(String name, String lastName, int age) {
        daoJDBC.saveUser(name, lastName, (byte)age);
        System.out.printf("Пользователь добавлен в базу данных");

    }

    public void saveUser(String name, String lastName, byte age) {
        daoJDBC.saveUser(name, lastName, age);
        System.out.printf("Пользователь добавлен в базу данных");

    }

    public void removeUserById(long id) {
        daoJDBC.removeUserById(id);
        System.out.printf("Пользователь удален базы данных");

    }

    public List<User> getAllUsers() throws SQLException {

        return daoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        daoJDBC.cleanUsersTable();

    }
}

