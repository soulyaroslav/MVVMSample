package soulyaroslav.com.mvvmgithubtest.views.profile;

import soulyaroslav.com.mvvmgithubtest.Utils.recycler.DiffCallback;

/**
 * Created by yaroslav on 5/16/17.
 */

public class MyDiffCallback extends DiffCallback<RepoItem> {

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getRepo().getName().equals(newList.get(newItemPosition).getRepo().getName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
