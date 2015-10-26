package myexamples.testingrealm.com.realmrecyclerview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import Model.BUS;
import Model.PersonObj;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class InputFragment extends Fragment {

    @Bind(R.id.inputText)
    EditText inputText;
    @Bind(R.id.inputBtn)
    Button inputBtn;
    @Bind(R.id.saveBtn)
    Button saveBtn;
    Realm realm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_input_fragment, container, false);
        ButterKnife.bind(this, v);

        inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonObj person = new PersonObj();
                person.setName(inputText.getText().toString());
                BUS.getInstance().post(person);

            }
        });
       saveBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(getActivity()).build();
               realm.getInstance(realmConfiguration);
               BUS.getInstance().post(realm);
           }
       });

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
