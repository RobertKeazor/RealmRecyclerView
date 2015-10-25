package View;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;


public interface MainActivityView {
    void LoadListFragement (Fragment fragment,FragmentActivity activity);
    void LoadBottomFragment (Fragment fragment,FragmentActivity activity);

}
