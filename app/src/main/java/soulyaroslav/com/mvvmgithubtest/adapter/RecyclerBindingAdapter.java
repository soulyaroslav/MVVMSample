package soulyaroslav.com.mvvmgithubtest.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav on 3/24/17.
 */

public class RecyclerBindingAdapter<T> extends RecyclerView.Adapter<RecyclerBindingAdapter.BindingViewHolder>{

    private int holderLayout;
    private int variableId;
    private AbstractList<T> items = new ArrayList<>();

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
        final T item = items.get(position);
//        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(listener != null) {
//                    listener.onItemClick(position, item);
//                }
//            }
//        });
        holder.getBinding().setVariable(variableId, item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setContent(List<T> items){
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
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
