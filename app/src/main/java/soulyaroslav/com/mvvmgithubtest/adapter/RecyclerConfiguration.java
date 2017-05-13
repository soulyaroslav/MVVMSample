package soulyaroslav.com.mvvmgithubtest.adapter;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * Created by yaroslav on 3/24/17.
 */

public class RecyclerConfiguration extends BaseObservable {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private RecyclerView.Adapter adapter;
    private RecyclerView.OnScrollListener onScrollListener;

    @BindingAdapter("app:configuration")
    public static void configureRecyclerView(RecyclerView recyclerView, RecyclerConfiguration configuration) {
        recyclerView.setLayoutManager(configuration.getLayoutManager());
        recyclerView.setItemAnimator(configuration.getItemAnimator());
        recyclerView.setAdapter(configuration.getAdapter());
        recyclerView.addOnScrollListener(configuration.getOnScrollListener());
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public void setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        this.itemAnimator = itemAnimator;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public RecyclerView.ItemAnimator getItemAnimator() {
        return itemAnimator;
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public RecyclerView.OnScrollListener getOnScrollListener() {
        return onScrollListener;
    }
}
