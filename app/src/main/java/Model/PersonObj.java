package Model;

import io.realm.RealmObject;


public class PersonObj extends RealmObject {
    private String Name;
    public PersonObj (){

    }

    public PersonObj(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
