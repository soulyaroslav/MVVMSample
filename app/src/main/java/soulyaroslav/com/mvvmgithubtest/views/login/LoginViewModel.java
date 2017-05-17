package soulyaroslav.com.mvvmgithubtest.views.login;

import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.view.View;

import soulyaroslav.com.mvvmgithubtest.Utils.Constants;
import soulyaroslav.com.mvvmgithubtest.rest.request.LoginRequest;
import soulyaroslav.com.mvvmgithubtest.views.ActivityViewModel;
import soulyaroslav.com.mvvmgithubtest.views.profile.ProfileActivity;

/**
 * Created by yaroslav on 3/23/17.
 */

public class LoginViewModel extends ActivityViewModel<LoginActivity> {

    private LoginRequest loginRequest;
    private ObservableBoolean isLoaded = new ObservableBoolean(true);

    public LoginViewModel(LoginActivity activity) {
        super(activity);
        init();
    }

    private void init(){
        loginRequest = new LoginRequest();
    }

    public View.OnClickListener onLoginClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        };
    }

    private void login(){
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        intent.putExtra(Constants.CREDENTIALS_BUNDLE_KEY, getLoginRequest().getName());
        getActivity().startActivity(intent);

//        FragmentTransaction transition = getActivity().getSupportFragmentManager().beginTransaction();
//        transition.replace(R.id.container, TestFragment.getInstance("3"));
//        transition.commit();
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        Toast.makeText(getActivity(), "text - " + s, Toast.LENGTH_SHORT).show();
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public ObservableBoolean getIsLoaded() {
        return isLoaded;
    }
}
