package Model;

import io.realm.RealmObject;

/**
 * Created by rob2cool on 10/25/15.
 */
public class PersonObj extends RealmObject {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
