package iram.student.tests;

import iram.student.model.Client;
import iram.student.patterns.Factory;
import iram.student.patterns.dao.*;

import java.util.ArrayList;
import java.util.List;

public class DaoClientTest {

    private static Dao<Client> client = Factory.getDaoClient();
    private static Client ourebi = new Client("ponsart","chloe","belgique","naast","rue joseph gaube","30",7062,true);
    private static List<Client> clients = new ArrayList<>();

    public static void testDaoClient(){

        //region insert
        System.out.println();
        client.insert(ourebi);
        //endregion

        //region select id
        ourebi = client.select(9);
        System.out.println("*----------select by id--------------*");
        System.out.println(ourebi.toString());
        //endregion

        //region update
        ourebi.setActif(false);
        client.update(ourebi);
        //endregion

        //region select all
        System.out.println("*----------select *--------------*");
        clients = client.selectAll();
        for (Client c : clients){
            System.out.println(c.toString());
        }
        //endregion

        //region delete
        client.delete(ourebi);
        //endregion

        //region select all
        System.out.println("*----------select *--------------*");
        clients = client.selectAll();
        for (Client c : clients){
            System.out.println(c.toString());
        }
        //endregion

    }


}
