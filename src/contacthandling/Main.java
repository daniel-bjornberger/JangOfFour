package contacthandling;

import databasehandling.*;

public class Main{
    public static void main (String [] args){

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
        System.out.println("1. on the way...");

        //SearchPageDb.getInstance().callDb(getCon,"Joel",1,10);
        //if (SearchPageDb.getInstance().callDb(getCon, "Joel", 1,10 )) {
        try {
            System.out.println("2. on the way...");
            //ResultSet resultSet = SearchPageDb.getInstance().getResultSet();

            DbHandler.getInstance().searchPage("Box");
            //SearchPageDb.getInstance().callDb(getCon,"01",1,10)

            System.out.println("3. on the way...");
            //System.out.println(resultSet);
            //ContactHandler.getInstance().createFromString(SearchPageDb.getInstance().getResultSet());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            }
            ContactHandler.getInstance().displayAllContacts();
        //} catch (SQLException e) {
        //        System.err.println(e);
        //    };


    }



}
