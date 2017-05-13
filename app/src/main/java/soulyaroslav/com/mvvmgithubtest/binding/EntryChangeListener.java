package soulyaroslav.com.mvvmgithubtest.binding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import soulyaroslav.com.mvvmgithubtest.BR;


/**
 * Created by yaroslav on 4/24/17.
 */

public class EntryChangeListener extends ObservableList.OnListChangedCallback {

    private final LayoutInflater inflater;
    private final ViewGroup target;
    private int layoutId;

    public EntryChangeListener(ViewGroup target, int layoutId) {
        this.target = target;
        this.layoutId = layoutId;
        this.inflater = (LayoutInflater) target.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void onChanged(ObservableList observableList) {
        resetView(target, layoutId, observableList);
    }

    @Override
    public void onItemRangeChanged(ObservableList observableList, int start, int count) {
        TransitionManager.beginDelayedTransition(target);
        final int end = start + count;
        for (int i = start; i < end; i++) {
            Object data = observableList.get(i);
            ViewDataBinding binding = bindLayout(inflater, target, layoutId, data);
            binding.setVariable(BR.data, observableList.get(i));
            target.removeViewAt(i);
            target.addView(binding.getRoot(), i);
        }
    }

    @Override
    public void onItemRangeInserted(ObservableList observableList, int start, int count) {
        TransitionManager.beginDelayedTransition(target);
        final int end = start + count;
        for (int i = end - 1; i >= start; i--) {
            Object entry = observableList.get(i);
            ViewDataBinding binding = bindLayout(inflater, target, layoutId, entry);
            target.addView(binding.getRoot(), start);
        }
    }

    @Override
    public void onItemRangeMoved(ObservableList observableList, int from, int to, int count) {
        TransitionManager.beginDelayedTransition(target);
        for (int i = 0; i < count; i++) {
            View view = target.getChildAt(from);
            target.removeViewAt(from);
            int destination = (from > to) ? to + i : to;
            target.addView(view, destination);
        }
    }

    @Override
    public void onItemRangeRemoved(ObservableList observableList, int start, int count) {
        TransitionManager.beginDelayedTransition(target);
        for (int i = 0; i < count; i++) {
            target.removeViewAt(start);
        }
    }

    private ViewDataBinding bindLayout(LayoutInflater inflater, ViewGroup parent, int layoutId, Object entry) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        binding.setVariable(BR.data, entry);
        return binding;
    }

    private void resetView(ViewGroup parent, int layoutId, List entries) {
        parent.removeAllViews();
        if(layoutId == 0) {
            return;
        }
        for (int i = 0; i < entries.size(); i++) {
            Object entry = entries.get(i);
            ViewDataBinding binding = bindLayout(inflater, parent, layoutId, entry);
            parent.addView(binding.getRoot());
        }
    }
}
