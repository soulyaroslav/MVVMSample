package soulyaroslav.com.mvvmgithubtest.views.profile;

import android.view.View;

import soulyaroslav.com.mvvmgithubtest.rest.response.Repos;

/**
 * Created by yaroslav on 5/11/17.
 */

public class RepoItem { // repo holder

    private OnItemClickListener onItemClickListener;
    private Repos item;

    public interface OnItemClickListener {
        void onItemClick(Repos item);
    }

    public RepoItem(Repos item) {
        this.item = item;
    }

    public void onTitleClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(item);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public Repos getRepo() {
        return item;
    }


}
