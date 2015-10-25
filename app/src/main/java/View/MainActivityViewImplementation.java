package View;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;

import myexamples.testingrealm.com.realmrecyclerview.InputFragment;
import myexamples.testingrealm.com.realmrecyclerview.ListFragment;
import myexamples.testingrealm.com.realmrecyclerview.MainActivity;
import myexamples.testingrealm.com.realmrecyclerview.R;

/**
 * Created by rob2cool on 10/25/15.
 */
public class MainActivityViewImplementation implements MainActivityView {
    @Override
    public void LoadListFragement(Fragment fragment, FragmentActivity activity) {
        FragmentManager fragmentManager =activity.getSupportFragmentManager();
        FragmentTransaction transaction =fragmentManager.beginTransaction();
        ListFragment mGridViewFragment= new ListFragment();
        transaction.add(R.id.topLayer,mGridViewFragment,"frag1");
        transaction.commit();

    }

    @Override
    public void LoadBottomFragment(Fragment fragment, FragmentActivity activity) {

        FragmentManager fragmentManager =activity.getSupportFragmentManager();
        FragmentTransaction transaction =fragmentManager.beginTransaction();
        InputFragment BottomFragment= new InputFragment();
        transaction.add(R.id.bottomLayer,BottomFragment,"frag2");
        transaction.commit();
    }
}
