package soulyaroslav.com.mvvmgithubtest.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

/**
 * Created by yaroslav on 5/18/17.
 */

public class ResourceUtil {

    private static ResourceUtil instance;
    private Context context;

    private ResourceUtil(final Context context) {
        this.context = context;
    }

    /**
     * Call this method in the Application
     * @param context application context
     * */
    public static void init(final Context context) {
        if(instance == null) {
            instance = new ResourceUtil(context);
        }
    }

    public ResourceUtil getInstance() {
        return instance;
    }

    public String getString(@StringRes int stringId) {
        return context.getString(stringId);
    }

    public int getColor(@ColorRes int colorId) {
        return ContextCompat.getColor(context, colorId);
    }

    public Drawable getDrawable(@DrawableRes int drawableId) {
        return ContextCompat.getDrawable(context, drawableId);
    }

    public float getDimension(@DimenRes int dimenId) {
        return context.getResources().getDimension(dimenId);
    }
}
