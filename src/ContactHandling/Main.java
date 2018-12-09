package ContactHandling;

import databaseHandling.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main (String [] args){
        DBValidator dbValidator=new DBValidator();
        Contact c=new Contact(80,"JJ","Gunnarsson","112","Guldheden","joel@.se");
        AddDb.callDb(DBValidator.getCon(),c);

        Contact updatedContact = new Contact(80,
        "Joel", "Gunnarson",
                "112","Guldheden","joel@.se");
        UpdateDb.callDb(DBValidator.getCon(), updatedContact);

        //DeleteDb.callDb(DBValidator.getCon(), c);

        //ContactHandler.getInstance().createFromString()
        //new DbHandler.searchPage(c)

        java.sql.Connection getCon = DBValidator.getCon();
        System.out.println("getCon: " + getCon);
        //SearchPageDb.getInstance().callDb(getCon,"Joel",1,10);
        if (SearchPageDb.getInstance().callDb(getCon, "Joel", 1,10 )) {
            try {
                ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());
            } catch (SQLException e) {
                System.err.println(e);
            };
        }

    }



}
