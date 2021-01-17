package iram.student.dao;

import iram.student.dao.impl.DaoClient;
import iram.student.dao.impl.DaoFacture;
import iram.student.dao.impl.DaoMedicament;
import iram.student.dao.impl.DaoUser;
import iram.student.model.Client;
import iram.student.model.Facture;
import iram.student.model.Medicament;
import iram.student.model.User;
import iram.student.singleton.DBConnexion;

import java.sql.Connection;

public class Factory {
    protected static final Connection conn = DBConnexion.getInstance();

    public static Dao<Client> getDaoClient(){
        return new DaoClient(conn);
    }
    public static Dao<User> getDaoUser(){
        return new DaoUser(conn);
    }
    public static Dao<Facture> getDaoFacture(){
        return new DaoFacture(conn);
    }
    public static Dao<Medicament> getDaoMedicament(){
        return new DaoMedicament(conn);
    }
}
