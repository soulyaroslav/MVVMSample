package soulyaroslav.com.mvvmgithubtest.views.fragment;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by yaroslav on 5/12/17.
 */

public class FragmentViewModel extends soulyaroslav.com.mvvmgithubtest.views.FragmentViewModel<TestFragment> {

    private Bundle bundle;
    private ObservableField<String> page = new ObservableField<>();

    public FragmentViewModel(TestFragment fragment) {
        super(fragment);
        extractBundle();
    }

    private void extractBundle() {
        bundle = getFragment().getBundle();
        if(bundle != null) {
            setPage(bundle.getString("key", "1"));
        }
    }

    public ObservableField<String> getPage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setPage("6");
            }
        }, 2000);
        return page;
    }

    private void setPage(String page) {
        this.page.set(page);
    }
}
