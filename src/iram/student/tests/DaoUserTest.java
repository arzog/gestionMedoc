package iram.student.tests;

import iram.student.model.User;
import iram.student.patterns.Factory;
import iram.student.patterns.dao.Dao;

public class DaoUserTest {
    private static Dao<User> userDao = Factory.getDaoUser();
}
