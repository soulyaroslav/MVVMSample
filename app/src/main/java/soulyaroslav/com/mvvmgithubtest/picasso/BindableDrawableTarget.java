package soulyaroslav.com.mvvmgithubtest.picasso;

import android.content.res.Resources;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by yaroslav on 3/24/17.
 */

public class BindableDrawableTarget implements Target {

    private ObservableField<Drawable> field;
    private Resources resources;

    public BindableDrawableTarget(ObservableField<Drawable> field, Resources resources) {
        this.field = field;
        this.resources = resources;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        field.set(new BitmapDrawable(resources, bitmap));
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
        field.set(errorDrawable);
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {
        field.set(placeHolderDrawable);
    }
}
