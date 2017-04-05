package soulyaroslav.com.mvvmgithubtest.rest;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import soulyaroslav.com.mvvmgithubtest.rest.response.LoginResponse;
import soulyaroslav.com.mvvmgithubtest.rest.response.Repos;

/**
 * Created by yaroslav on 3/23/17.
 */

public interface GitHubAPI {

    @GET("users/{user}")
    Observable<LoginResponse> getProfile(@Path("user") String user);

    @GET("users/{user}/repos")
    Observable<List<Repos>> getRepos(@Path("user") String user);
}
