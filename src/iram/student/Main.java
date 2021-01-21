package iram.student;

import iram.student.dao.Factory;
import iram.student.dao.impl.DaoClient;
import iram.student.singleton.DBConnexion;

public class Main {

    public static void main(String[] args) {
        // test connection db
        DBConnexion.getInstance();
    }
}
