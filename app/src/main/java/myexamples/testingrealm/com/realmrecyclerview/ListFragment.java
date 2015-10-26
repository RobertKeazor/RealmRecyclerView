package myexamples.testingrealm.com.realmrecyclerview;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.util.SortedList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import Model.BUS;
import Model.Basic_Read_Write;
import Model.ListAdapter;
import Model.PersonObj;
import Model.Read_Write_Implementation;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ListFragment extends Fragment {

    Collection<PersonObj> items = new ArrayList<PersonObj>();
    ArrayList<PersonObj> newitems = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manger;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Boolean isEmptyDatabase = true;
    Basic_Read_Write CRUD_STUFF;
    Realm realm;
    RecyclerView.Adapter mAdapter;
    Basic_Read_Write IO;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_list_fragment, container, false);
        CRUD_STUFF = new Read_Write_Implementation();
        Toast.makeText(getActivity(), "Good", Toast.LENGTH_SHORT).show();
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(getActivity()).build();
        realm.getInstance(getActivity());
        BUS.getInstance().register(this);
        pref = getActivity().getSharedPreferences("EmptyTable", Context.MODE_PRIVATE);
        isEmptyDatabase = pref.getBoolean("DATABASE_EMPTY", true);
        recyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        if (isEmptyDatabase) {

            createDummyItem();
        } else {
            items = CRUD_STUFF.DatabaseLoadFromList(realm);
        }
        loadRecyclerView();
        return v;
    }

    private void createDummyItem() {

        newitems.add(new PersonObj("Please Start inputting Data"));
    }

    private void loadRecyclerView() {


        manger = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manger);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(itemDecoration);
        mAdapter = new ListAdapter(newitems, getActivity());
        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onPause() {
        super.onPause();
        BUS.getInstance().unregister(this);
    }

    @Subscribe

    public void Additem(PersonObj person1) {
        newitems.add(person1);

        mAdapter = new ListAdapter(newitems, getActivity());
        recyclerView.setAdapter(mAdapter);
        Toast.makeText(getActivity(), newitems.get(1).getName(), Toast.LENGTH_SHORT).show();


    }


    @Subscribe
    public void SaveList(Realm realm) {
      IO = new Read_Write_Implementation();
        IO.DatabaseSave(realm, newitems);
        isEmptyDatabase = false;
        pref = getActivity().getSharedPreferences("EmptyTable", Context.MODE_PRIVATE);
        editor =pref.edit();
        editor.putBoolean("DATABASE_EMPTY",false);
        editor.commit();
    }
}