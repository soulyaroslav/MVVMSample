package soulyaroslav.com.mvvmgithubtest.views;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yaroslav on 3/23/17.
 */

public abstract class ActivityViewModel<A extends AppCompatActivity> extends BaseObservable {

    private A activity;

    public ActivityViewModel(A activity) {
        this.activity = activity;
    }

    public void onStart() {

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
    public void onResume() {

    }
    public void onPause() {

    }
    public void onStop() {

    }

    public A getActivity() {
        return activity;
    }
}
