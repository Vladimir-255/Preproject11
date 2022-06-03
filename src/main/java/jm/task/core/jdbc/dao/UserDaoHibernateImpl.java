package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = Util.getConnectionHibernate().openSession();
        session.beginTransaction();
        try {
            session.createSQLQuery(
                            "CREATE TABLE user  (ID INT NOT NULL AUTO_INCREMENT, name VARCHAR(60) NOT NULL, last_name VARCHAR(40) NOT NULL, Age INT, PRIMARY KEY (id));")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Таблица создана");
        } catch (Exception e) {
            System.out.println("Таблица уже существует");
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getConnectionHibernate().openSession();
        session.beginTransaction();
        try {
            session.createSQLQuery(
                            "DROP TABLE user")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Таблица удалена");
        } catch (Exception e) {
            System.out.println("Таблицы не существует");
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getConnectionHibernate().openSession();
        try {
            User user = new User(name, lastName, age);
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("Пользователь добавлен");
        } catch (HibernateException h) {
            h.printStackTrace();
            System.out.println("Ошибка добавления пользователя");
        } finally {
            if (session.isConnected()) {
                session.close();
            }
        }

    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getConnectionHibernate().openSession();
        try {
            session.beginTransaction();
            User luser = session.get(User.class, id);
            session.delete(luser);
            session.getTransaction().commit();
            System.out.println("Пользователь удален");
        } catch (Exception h) {
            h.printStackTrace();
            System.out.println("Ошибка удаления пользователя");
        } finally {
            if (session.isConnected()) {
                session.close();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getConnectionHibernate().openSession();
        List<User> userList = new ArrayList<>();
        try {
            session.beginTransaction();
            userList = session.createQuery("from User").list();
            session.getTransaction().commit();
            System.out.println(userList);
        } catch (Exception h) {
            h.printStackTrace();
            System.out.println("Ошибка получения пользователей");
        } finally {
            if (session.isConnected()) {
                session.close();
            }
        }

        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getConnectionHibernate().openSession();
        try {
            session.beginTransaction();


            session.getTransaction().commit();
            System.out.println("Все пользователи удалены");
        } catch (Exception h) {
            h.printStackTrace();
            System.out.println("Ошибка удаления пользователей");
        } finally {
            if (session.isConnected()) {
                session.close();
            }
        }

    }
}
