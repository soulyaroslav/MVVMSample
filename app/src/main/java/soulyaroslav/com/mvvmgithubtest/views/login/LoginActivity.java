package soulyaroslav.com.mvvmgithubtest.views.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import soulyaroslav.com.mvvmgithubtest.BR;
import soulyaroslav.com.mvvmgithubtest.R;
import soulyaroslav.com.mvvmgithubtest.databinding.LoginActivityBinding;
import soulyaroslav.com.mvvmgithubtest.views.BindingActivity;

/**
 * Created by yaroslav on 3/23/17.
 */

public class LoginActivity extends BindingActivity<LoginActivityBinding, LoginViewModel> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public LoginViewModel onCreate() {
        return new LoginViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.login_activity;
    }
}
