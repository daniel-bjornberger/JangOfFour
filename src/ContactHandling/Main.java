package ContactHandling;

import databaseHandling.AddDb;
import databaseHandling.DBValidator;
import databaseHandling.DeleteDb;
import databaseHandling.UpdateDb;

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
    }



}
