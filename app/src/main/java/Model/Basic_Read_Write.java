package Model;

import android.content.Context;

import java.util.Collection;

import io.realm.Realm;

/**
 * Created by rob2cool on 10/25/15.
 */
public interface Basic_Read_Write {
    void   DatabaseSave (Realm realm,Collection <PersonObj>persons);
    void DatabaseAddItem (String name,Realm realm,PersonObj persons);
}
