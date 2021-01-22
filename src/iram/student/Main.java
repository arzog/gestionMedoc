package iram.student;

import iram.student.model.Client;
import iram.student.patterns.Factory;
import iram.student.patterns.dao.Dao;
import iram.student.patterns.singleton.DBConnexion;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //region test connection db
        DBConnexion.getInstance();
        //endregion

        //region test dao client
        Dao<Client> client = Factory.getDaoClient();
        Client ourebi = new Client("ponsart","chloe","belgique","naast","rue joseph gaube","30",7062,true);


        //region insert
        /*client.insert(ourebi);*/
        //endregion

        //region select id
        ourebi = client.select(5);
        System.out.println("*----------select by id--------------*");
        System.out.println(ourebi.toString());
        //endregion

        //region update
        ourebi.setActif(false);
        client.update(ourebi);
        //endregion

        //region delete
        //endregion



        //region select all
        System.out.println("*----------select *--------------*");
        List<Client> clients = client.selectAll();
        for (Client c : clients){
            System.out.println(c.toString());
        }
        //endregion

        //endregion
    }
}
