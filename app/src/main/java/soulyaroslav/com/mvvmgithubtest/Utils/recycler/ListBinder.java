package soulyaroslav.com.mvvmgithubtest.Utils.recycler;

import android.support.v7.util.DiffUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav on 5/17/17.
 */

public class ListBinder<E> {

    private final DiffCallback<E> diffCallback;
    private List<E> currentList = new ArrayList<>();
    private OnDataChangeListener onDataChangeListener;
    private OnUpdateAdapterContent<E> onUpdateAdapterContent;

    public interface OnDataChangeListener {
        void onChange(DiffUtil.DiffResult diffResult);
    }

    public interface OnUpdateAdapterContent<E> {
        void onUpdateContent(List<E> data);
    }

    public ListBinder(DiffCallback<E> diffCallback) {
        this.diffCallback = diffCallback;
    }

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener;
    }

    public void setOnUpdateAdapterContent(OnUpdateAdapterContent<E> onUpdateAdapterContent) {
        this.onUpdateAdapterContent = onUpdateAdapterContent;
    }

    public void notifyDataChange(List<E> data) {
        notifyChanges(data);
        notifyAdapter();
    }

    private void notifyChanges(List<E> data) {
        DiffUtil.DiffResult diffResult = calculateDifference(data);
        if(onDataChangeListener != null) {
            onDataChangeListener.onChange(diffResult);
        }
    }

    private void notifyAdapter() {
        if(onUpdateAdapterContent != null) {
            onUpdateAdapterContent.onUpdateContent(currentList);
        }
    }

    private DiffUtil.DiffResult calculateDifference(List<E> data) {
        List<E> newList = new ArrayList<>(data);
        diffCallback.setContent(newList, currentList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        currentList = newList;
        return diffResult;
    }
}

