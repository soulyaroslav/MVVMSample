package soulyaroslav.com.mvvmgithubtest.rest.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yaroslav on 3/23/17.
 */

public class LoginRequest {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
