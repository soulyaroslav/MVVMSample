package soulyaroslav.com.mvvmgithubtest.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yaroslav on 3/24/17.
 */

public class Repos {
    @SerializedName("name")
    private String name;
    @SerializedName("language")
    private String language;
    @SerializedName("default_branch")
    private String branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
