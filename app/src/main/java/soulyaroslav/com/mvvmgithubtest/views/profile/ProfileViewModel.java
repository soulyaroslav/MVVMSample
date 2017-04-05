package soulyaroslav.com.mvvmgithubtest.views.profile;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observer;
import soulyaroslav.com.mvvmgithubtest.R;
import soulyaroslav.com.mvvmgithubtest.Utils.Constants;
import soulyaroslav.com.mvvmgithubtest.adapter.RecyclerBindingAdapter;
import soulyaroslav.com.mvvmgithubtest.adapter.RecyclerConfiguration;
import soulyaroslav.com.mvvmgithubtest.picasso.BindableDrawableTarget;
import soulyaroslav.com.mvvmgithubtest.picasso.CircleTransformation;
import soulyaroslav.com.mvvmgithubtest.rest.response.LoginResponse;
import soulyaroslav.com.mvvmgithubtest.rest.response.Repos;
import soulyaroslav.com.mvvmgithubtest.views.ActivityViewModel;

/**
 * Created by yaroslav on 3/24/17.
 */

public class ProfileViewModel extends ActivityViewModel<ProfileActivity> {

    private Bundle bundle;
    private ProfileModel profileModel;
    private LoginResponse response;
    private ObservableField<Drawable> avatar = new ObservableField<>();
    private ObservableBoolean isLoaded = new ObservableBoolean(false);
    private RecyclerConfiguration configuration = new RecyclerConfiguration();
    private RecyclerBindingAdapter<Repos> adapter;

    public ProfileViewModel(ProfileActivity activity) {
        super(activity);
        init();
    }

    private void init(){
        this.bundle = getActivity().getBundle();
        profileModel = new ProfileModel();
        initRecycler();
    }

    @Override
    public void onResume() {
        super.onResume();
        getProfile();
    }

    private void initRecycler(){
        adapter = getAdapter();
        configuration.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        configuration.setItemAnimator(new DefaultItemAnimator());
        configuration.setAdapter(adapter);
    }

    private void getProfile(){
        if(bundle != null) {
            isLoaded.set(false);
            String credentials = bundle.getString(Constants.CREDENTIALS_BUNDLE_KEY);
            profileModel.getProfile(credentials).subscribe(new Observer<LoginResponse>() {
                @Override
                public void onCompleted() {
                    isLoaded.set(true);
                }

                @Override
                public void onError(Throwable e) {
                    isLoaded.set(true);
                }

                @Override
                public void onNext(LoginResponse response) {
                    prepareResponseInformation(response);
                    notifyChange();
                }
            });
            getRepos(credentials);
        }
    }

    private void prepareResponseInformation(LoginResponse response) {
        this.response = response;
        BindableDrawableTarget drawableTarget = new BindableDrawableTarget(avatar, getActivity().getResources());
        Picasso.with(getActivity()).load(response.getAvatar()).transform(new CircleTransformation()).into(drawableTarget);
    }

    private RecyclerBindingAdapter<Repos> getAdapter() {
        RecyclerBindingAdapter<Repos> adapter = new RecyclerBindingAdapter<>(R.layout.repos_item_layout, BR.repo);
        adapter.setListener(new RecyclerBindingAdapter.OnItemClickListener<Repos>() {
            @Override
            public void onItemClick(int position, Repos item) {
                Toast.makeText(getActivity(), item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return adapter;
    }

    private void getRepos(String credentials){
        profileModel.getRepos(credentials).subscribe(new Observer<List<Repos>>() {
            @Override
            public void onCompleted() {
                isLoaded.set(true);
            }

            @Override
            public void onError(Throwable e) {
                isLoaded.set(true);
            }

            @Override
            public void onNext(List<Repos> reposes) {
                isLoaded.set(true);
                adapter.setContent(reposes);
            }
        });
    }

    public LoginResponse getLoginResponse() {
        return response;
    }

    public ObservableField<Drawable> getAvatar() {
        return avatar;
    }

    public ObservableBoolean getIsLoaded() {
        return isLoaded;
    }

    public RecyclerConfiguration getConfiguration() {
        return configuration;
    }
}
