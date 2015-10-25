package Presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import Model.Basic_Read_Write;
import View.MainActivityView;
import View.MainActivityViewImplementation;
import myexamples.testingrealm.com.realmrecyclerview.InputFragment;
import myexamples.testingrealm.com.realmrecyclerview.ListFragment;

/**
 * Created by rob2cool on 10/25/15.
 */
public class MainActivityPresenterImplementation implements MainActivityPresenter {

    MainActivityView mainActivityView;
    @Override
    public void onCreate(FragmentActivity activity) {
        mainActivityView=new MainActivityViewImplementation();
        mainActivityView.LoadListFragement(new ListFragment(),activity );
        mainActivityView.LoadBottomFragment(new InputFragment(),activity);

    }

    @Override
    public void onResume(FragmentActivity activity) {

    }


}
