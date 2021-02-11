package iram.student;

import iram.student.tests.DaoClientTest;
import iram.student.tests.DaoUserTest;

public class Main {

    public static void main(String[] args) {

        //Test connection db => gestionmedoc
        //DBConnexion.getInstance();

        //Tests Dao client
        DaoClientTest.testDaoClient();

        //Tests Dao user
        //DaoUserTest.testUserDao();

    }
}
