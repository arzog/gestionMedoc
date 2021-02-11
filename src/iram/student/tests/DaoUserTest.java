package iram.student.tests;

import iram.student.enums.RoleUser;
import iram.student.model.User;
import iram.student.patterns.Factory;
import iram.student.patterns.dao.Dao;

import java.util.List;

public class DaoUserTest {
    private final static Dao<User> userDao = Factory.getDaoUser();
    private static User francois = new User(RoleUser.USER,"french","14121988","francois.beumier@hotmail.fr",3);

    public static void testUserDao(){
        //region select *
        List<User> users = userDao.selectAll();
        System.out.println("*------SELECT ALL USERS------*");
        for(User u : users){
            System.out.println(u.toString());
        }
        System.out.println();
        //endregion

        /*

        //region select id
        System.out.println("*------SELECT ID 2------*");
        System.out.println(userDao.select(2));
        System.out.println();
        //endregion

        //region insert user
        System.out.println("*------INSERT USER------*");
        userDao.insert(francois);
        System.out.println();
        //endregion

        //region select id
        System.out.println("*------SELECT ID 5------*");
        francois = userDao.select(4);
        System.out.println(francois);
        System.out.println();
        //endregion

        //region update user francois
        System.out.println("*------UDPATE FRANCOIS------*");
        francois.setUsername("yojimbo");
        userDao.update(francois);
        //endregion

        //region select id
        System.out.println("*------SELECT ID 5------*");
        francois = userDao.select(5);
        System.out.println(francois);
        System.out.println();
        //endregion

        //region delete francois
        System.out.println("*------DELETE FRANCOIS------*");
        userDao.delete(francois);
        System.out.println();
        //endregion

        //region select *
        users = userDao.selectAll();
        System.out.println("*------SELECT ALL USERS------*");
        for(User u : users){
            System.out.println(u.toString());
        }
        System.out.println();
        //endregion

        */
    }
}
