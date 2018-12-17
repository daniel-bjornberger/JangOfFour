#/bin/bash
repository="https://github.com/daniel-bjornberger/JangOfFour.git"
dir=JangOfFour12
mkdir -p "$dir"
git clone "$repository" "$dir/"
mkdir -p $dir/bin
javac -d "$dir/bin" -cp "$dir/sqlite-jdbc-3.23.1.jar;$dir/jfxrt.jar;.;$dir/src" "$dir/src/userinterface/*.java" "$dir/src/contacthandling/*.java" "$dir/src/main/*.java" "$dir/src/databasehandling/*.java"
cp $dir/src/userinterface/ListOfContactsView.FXML $dir/bin/userinterface
cp $dir/src/userinterface/ContactView.FXML $dir/bin/userinterface
cp $dir/src/userinterface/style.css $dir/bin/userinterface
java -cp "$dir;$dir/bin;$dir/sqlite-jdbc-3.23.1.jar;$dir/jfxrt.jar;." userinterface.ContactListMain
