package soulyaroslav.com.mvvmgithubtest.views.list;

import android.databinding.BaseObservable;

/**
 * Created by yaroslav on 4/24/17.
 */

public class Entries extends BaseObservable {
    private String entry;

    public Entries(String entry) {
        this.entry = entry;
    }

    public String getEntry() {
        return entry;
    }
}
