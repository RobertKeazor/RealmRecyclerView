package myexamples.testingrealm.com.realmrecyclerview;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Model.BUS;
import Model.Basic_Read_Write;
import Model.ListAdapter;
import Model.PersonObj;
import Model.Read_Write_Implementation;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ListFragment extends Fragment {

    Collection <PersonObj> items= new ArrayList<PersonObj>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manger;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Boolean isEmptyDatabase=true;
    Basic_Read_Write CRUD_STUFF;
    Realm realm;
    RecyclerView.Adapter mAdapter;


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
        pref =getActivity().getSharedPreferences("EmptyTable", Context.MODE_PRIVATE);
        isEmptyDatabase= pref.getBoolean("DATABASE_EMPTY",true);
        recyclerView= (RecyclerView) v.findViewById(R.id.my_recycler_view);
        if (isEmptyDatabase) {

            createDummyItem();
        }
        else {items=CRUD_STUFF.DatabaseLoadFromList(realm);}
        loadRecyclerView();
        return v;
    }

    private void createDummyItem() {

        items.add(new PersonObj("Please Start inputting Data"));
    }

    private void loadRecyclerView() {



        manger = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manger);

        mAdapter = new ListAdapter(items,getActivity());
        recyclerView.setAdapter(mAdapter);



    }

    @Override
    public void onPause() {
        super.onPause();
        BUS.getInstance().unregister(this);
    }

    @Subscribe

    public void Additem (PersonObj person)
    {
       items.add(person);
        mAdapter.notifyDataSetChanged();
        Toast.makeText(getActivity(), "Entered", Toast.LENGTH_SHORT).show();

    }

}
