package soulyaroslav.com.mvvmgithubtest.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ListenerUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import soulyaroslav.com.mvvmgithubtest.BR;
import soulyaroslav.com.mvvmgithubtest.R;

/**
 * Created by yaroslav on 4/24/17.
 */

public final class BindingAdapters {
    private BindingAdapters() {
    }

    @BindingAdapter("app:image")
    public static void setImageViewRecourse(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter({"entries", "layout"})
    public static <T> void setEntries(ViewGroup viewGroup, ObservableList<T> oldEntries,
                                      int oldLayoutId, ObservableList<T> newEntries, int newLayoutId) {
        if(oldEntries == newEntries && oldLayoutId == newLayoutId) {
            return; // nothing has changed
        }
        EntryChangeListener listener = ListenerUtil.getListener(viewGroup, R.id.entryListener);
        if(oldEntries != newEntries && listener != null) {
            oldEntries.removeOnListChangedCallback(listener);
        }
        if(newEntries == null) {
            viewGroup.removeAllViews();
        } else {
            if (listener == null) {
                listener = new EntryChangeListener(viewGroup, newLayoutId);
                ListenerUtil.trackListener(viewGroup, listener, R.id.entryListener);
            } else {
                listener.setLayoutId(newLayoutId);
            }
            if(newEntries != oldEntries) {
                newEntries.addOnListChangedCallback(listener);
            }
            resetViews(viewGroup, newLayoutId, newEntries);
        }
    }

    private static ViewDataBinding bindLayout(LayoutInflater inflater, ViewGroup parent, int layoutId, Object entry) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        binding.setVariable(BR.viewModel, entry);
        return binding;
    }

    private static void resetViews(ViewGroup parent, int layoutId, List entries) {
        parent.removeAllViews();
        if (layoutId == 0) {
            return;
        }
        LayoutInflater inflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < entries.size(); i++) {
            Object entry = entries.get(i);
            ViewDataBinding binding = bindLayout(inflater, parent, layoutId, entry);
            parent.addView(binding.getRoot());
        }
    }
}
