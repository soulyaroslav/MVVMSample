package soulyaroslav.com.mvvmgithubtest.views.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;

import soulyaroslav.com.mvvmgithubtest.BR;
import soulyaroslav.com.mvvmgithubtest.R;
import soulyaroslav.com.mvvmgithubtest.databinding.ProfileActivityBinding;
import soulyaroslav.com.mvvmgithubtest.views.BindingActivity;

/**
 * Created by yaroslav on 3/24/17.
 */

public class ProfileActivity extends BindingActivity<ProfileActivityBinding, ProfileViewModel>{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public ProfileViewModel onCreate() {
        return new ProfileViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.profile_activity;
    }
}
