package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.saveUser("Ivan", "Ivanov", (byte)45);
       // userService.saveUser("Ivan", "Ivanov", 35);
        //  userService.saveUser("Ivan", "Ivanov", (byte) 37);
//        userService.cleanUsersTable();
       // List<User> userList = userService.getAllUsers();

    }
}
