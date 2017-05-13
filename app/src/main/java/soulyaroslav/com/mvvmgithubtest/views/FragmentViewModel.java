package soulyaroslav.com.mvvmgithubtest.views;

import android.databinding.BaseObservable;
import android.support.v4.app.Fragment;

/**
 * Created by yaroslav on 5/12/17.
 */

public abstract class FragmentViewModel<F extends Fragment> extends BaseObservable {

    private F fragment;

    public FragmentViewModel(F fragment) {
        this.fragment = fragment;
    }

    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {

    }

    public F getFragment() {
        return fragment;
    }
}
