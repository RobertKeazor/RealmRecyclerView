package Model;

import android.content.Context;

import java.util.Collection;

import io.realm.Realm;
import io.realm.RealmResults;


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

    @Override
    public Collection<PersonObj> DatabaseLoadFromList(Realm realm) {
        realm.beginTransaction();
        RealmResults<PersonObj> persons = realm.where(PersonObj.class).findAll();

        return persons;
    }


}
