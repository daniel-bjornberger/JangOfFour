
------------------------
Running the program
------------------------

Please download and run our script "jangoffourscript.sh" to download,compile and run the appliction. The script can be found in this repository. 

If preferred you can use commands below instead of run and download script.

 
repository="https://github.com/daniel-bjornberger/JangOfFour.git"
dir=JangOfFour
mkdir -p "$dir"
git clone "$repository" "$dir/"
cd "$dir"
mvn clean package
cp src/main/java/userinterface/ListOfContactsView.FXML target/classes/userinterface
cp src/main/java/userinterface/ContactView.FXML target/classes/userinterface
cp src/main/java/userinterface/style.css target/classes/userinterface
mvn exec:java -Dexec.mainClass="userinterface.ContactListMain"




------------------------
Program Interface
------------------------

The Contact Book program is a well developed Contact List assistant with
options to Search through your contacts, add contacts, edit or remove one.
Browsing is simple and intuitive.


The graphical user interface is intuitive and easy to manage:
1. Search Contacts by typing in the search term
2. List all contacts by clicking the "List all contacts" button
3. Add new contact by clicking the "Add new contact" button
   which takes you to the "Add contact" view
4. Update a contact by clicking a contact name and
	clicking the "Update Contact". The program takes you to
	to the "Update contact" view where use can update contact details.
5. Delete contact by clicking a contact and clicking the "Delete Contact"
	button.


------------------------
Some Technical details
------------------------

> Singleton design pattern is used for handling of instances in the program.
  This class is used for contacthandling and the databasehandling

> The program is mainly divided into three packages:
  contacthandling, databasehandling, userinterface.

> The database is an integrated Sqlite3 file.
  Contact handling happens after database connection is made with the database.

