package soulyaroslav.com.mvvmgithubtest.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yaroslav on 3/23/17.
 */

public class LoginResponse {
    @SerializedName("login")
    private String name;
    @SerializedName("avatar_url")
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
