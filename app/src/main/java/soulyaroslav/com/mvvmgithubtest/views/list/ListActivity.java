package soulyaroslav.com.mvvmgithubtest.views.list;

import soulyaroslav.com.mvvmgithubtest.BR;
import soulyaroslav.com.mvvmgithubtest.R;
import soulyaroslav.com.mvvmgithubtest.databinding.ListActivityBinding;
import soulyaroslav.com.mvvmgithubtest.views.BindingActivity;

/**
 * Created by yaroslav on 4/24/17.
 */

public class ListActivity extends BindingActivity<ListActivityBinding, ListViewModel>{
    @Override
    public ListViewModel onCreate() {
        return new ListViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_activity;
    }
}
