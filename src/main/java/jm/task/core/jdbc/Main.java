package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.security.auth.login.AppConfigurationEntry;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        //userService.dropUsersTable();
        //userDaoHibernate.createUsersTable();
        //userService.createUsersTable();
        //       userDaoHibernate.saveUser("ivan", "ivanov", (byte)56);
        //userDaoHibernate.cleanUsersTable();
        //userService.saveUser("Ivan", "Ivanov", 45);
        //userDaoHibernate.dropUsersTable();
        //userDaoHibernate.createUsersTable();
        //userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();
    }
}
