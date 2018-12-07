package ContactHandling;

import databaseHandling.AddDb;
import databaseHandling.DBValidator;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main (String [] args){
        DBValidator dbValidator=new DBValidator();
        Contact c=new Contact(78,"Joel","Gunnarsson","112","Guldheden","joel@.se");
        AddDb.callDb(DBValidator.getCon(),c);
    }



}
