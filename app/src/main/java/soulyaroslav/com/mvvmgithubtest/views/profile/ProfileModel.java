package soulyaroslav.com.mvvmgithubtest.views.profile;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import soulyaroslav.com.mvvmgithubtest.rest.GitHubAPI;
import soulyaroslav.com.mvvmgithubtest.rest.RestService;
import soulyaroslav.com.mvvmgithubtest.rest.response.LoginResponse;
import soulyaroslav.com.mvvmgithubtest.rest.response.Repos;

/**
 * Created by yaroslav on 3/23/17.
 */

public class ProfileModel {

    private GitHubAPI service;

    public ProfileModel() {
        service = RestService.createService();
    }

    public Observable<LoginResponse> getProfile(String credentials){
        return service.getProfile(credentials)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<Repos>> getRepos(String credentials){
        return service.getRepos(credentials)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
