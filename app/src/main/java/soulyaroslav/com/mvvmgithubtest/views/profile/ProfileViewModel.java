package soulyaroslav.com.mvvmgithubtest.views.profile;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import soulyaroslav.com.mvvmgithubtest.BR;
import soulyaroslav.com.mvvmgithubtest.R;
import soulyaroslav.com.mvvmgithubtest.Utils.Constants;
import soulyaroslav.com.mvvmgithubtest.adapter.RecyclerBindingAdapter;
import soulyaroslav.com.mvvmgithubtest.adapter.RecyclerConfiguration;
import soulyaroslav.com.mvvmgithubtest.rest.response.LoginResponse;
import soulyaroslav.com.mvvmgithubtest.rest.response.Repos;
import soulyaroslav.com.mvvmgithubtest.views.ActivityViewModel;


/**
 * Created by yaroslav on 3/24/17.
 */

public class ProfileViewModel extends ActivityViewModel<ProfileActivity> implements RepoItem.OnItemClickListener {

    private Bundle bundle;
    private ProfileModel profileModel;
    private LoginResponse response;
    private ObservableField<Drawable> avatar = new ObservableField<>();
    private String avatar1;
    private ObservableBoolean isLoaded = new ObservableBoolean(false);
    private RecyclerConfiguration configuration = new RecyclerConfiguration();
    private RecyclerBindingAdapter<RepoItem> adapter;

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
        adapter = new RecyclerBindingAdapter<>(R.layout.repos_item_layout, BR.repo);
        configuration.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        configuration.setItemAnimator(new DefaultItemAnimator());
        configuration.setOnScrollListener(onScrollListener);
        configuration.setAdapter(adapter);
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
//            Toast.makeText(getActivity(), "Cool, onScroll works!!", Toast.LENGTH_SHORT).show();
        }
    };

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
        avatar1 = response.getAvatar();
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
                List<RepoItem> repoItems = new ArrayList<>();
                for(int i = 0; i < reposes.size(); i++) {
                    Repos repos = reposes.get(i);
                    RepoItem repoItem = new RepoItem(repos);
                    repoItem.setOnItemClickListener(ProfileViewModel.this);
                    repoItems.add(repoItem);
                }
                adapter.setContent(repoItems);
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

    @Override
    public void onItemClick(Repos item) {
        Toast.makeText(getActivity(), item.getName() + " - " + item.getLanguage(), Toast.LENGTH_SHORT).show();
    }

    public String getAvatar1() {
        return avatar1;
    }
}
