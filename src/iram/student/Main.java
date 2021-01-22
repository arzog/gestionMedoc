package iram.student;

import iram.student.patterns.singleton.DBConnexion;

public class Main {

    public static void main(String[] args) {
        // test connection db
        DBConnexion.getInstance();
    }
}
