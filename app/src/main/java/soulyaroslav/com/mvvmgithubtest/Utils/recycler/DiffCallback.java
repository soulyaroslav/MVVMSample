package soulyaroslav.com.mvvmgithubtest.Utils.recycler;

import android.support.v7.util.DiffUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav on 5/17/17.
 */

public abstract class DiffCallback<E> extends DiffUtil.Callback {
    protected List<E> newList = new ArrayList<>();
    protected List<E> oldList = new ArrayList<>();

    public void setContent(List<E> newList, List<E> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }
}
