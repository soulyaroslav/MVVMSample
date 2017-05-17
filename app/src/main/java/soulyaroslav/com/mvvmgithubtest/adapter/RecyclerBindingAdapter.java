package soulyaroslav.com.mvvmgithubtest.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import soulyaroslav.com.mvvmgithubtest.Utils.recycler.ListBinder;

/**
 * Created by yaroslav on 3/24/17.
 */

public class RecyclerBindingAdapter<E> extends RecyclerView.Adapter<RecyclerBindingAdapter.BindingViewHolder>
        implements ListBinder.OnUpdateAdapterContent<E> {

    private int holderLayout;
    private int variableId;
    private List<E> items = new ArrayList<>();

    public RecyclerBindingAdapter(int holderLayout, int variableId) {
        this.holderLayout = holderLayout;
        this.variableId = variableId;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(holderLayout, parent, false);
        return new BindingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, final int position) {
        final E item = items.get(position);
        holder.getBinding().setVariable(variableId, item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onUpdateContent(List<E> data) {
        this.items = data;
    }

    public static class BindingViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}
