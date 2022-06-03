package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.*;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mySQL://localhost:3306/newdb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static SessionFactory sessionFactory;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getConnectionHibernate() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, DRIVER);
        properties.setProperty(Environment.URL, URL);
        properties.setProperty(Environment.USER, USERNAME);
        properties.setProperty(Environment.PASS, PASSWORD);
        SessionFactory sessionFactory = new Configuration().
                addProperties(properties).
                addAnnotatedClass(User.class).
                buildSessionFactory();
        System.out.println("Подключение к БД установлено");
        return sessionFactory;
    }
}