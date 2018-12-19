#/bin/bash
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
