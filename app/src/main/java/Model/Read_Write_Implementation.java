package Model;

import android.content.Context;

import java.util.Collection;

import io.realm.Realm;

/**
 * Created by rob2cool on 10/25/15.
 */
public class Read_Write_Implementation implements Basic_Read_Write {
    @Override
    public void DatabaseSave(Realm realm,  Collection<PersonObj> persons) {

        realm.beginTransaction();
        persons  = realm.copyToRealm(persons);
        realm.commitTransaction();


    }

    @Override
    public void DatabaseAddItem(String name, Realm realm, PersonObj persons) {
        realm.beginTransaction();
        persons.setName(name);
        realm.commitTransaction();
    }


}
