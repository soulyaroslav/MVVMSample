package soulyaroslav.com.mvvmgithubtest.binding;

import android.databinding.BindingConversion;
import android.view.View;

/**
 * Created by yaroslav on 3/24/17.
 */

public final class BindingConversions {

    private BindingConversions(){}

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
}
