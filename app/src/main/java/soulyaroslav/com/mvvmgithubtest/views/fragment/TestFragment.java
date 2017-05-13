package soulyaroslav.com.mvvmgithubtest.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import soulyaroslav.com.mvvmgithubtest.BR;
import soulyaroslav.com.mvvmgithubtest.R;
import soulyaroslav.com.mvvmgithubtest.databinding.FragmentLayoutBinding;
import soulyaroslav.com.mvvmgithubtest.views.BindingFragment;

/**
 * Created by yaroslav on 5/12/17.
 */

public class TestFragment extends BindingFragment<FragmentLayoutBinding, FragmentViewModel> {


    public static TestFragment getInstance(String number) {
        TestFragment fragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", number);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public FragmentViewModel onCreate() {
        return new FragmentViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_layout;
    }
}
