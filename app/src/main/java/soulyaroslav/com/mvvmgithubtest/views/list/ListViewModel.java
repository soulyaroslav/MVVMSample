package soulyaroslav.com.mvvmgithubtest.views.list;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;

import java.util.Random;

import soulyaroslav.com.mvvmgithubtest.views.ActivityViewModel;

/**
 * Created by yaroslav on 4/24/17.
 */

public class ListViewModel extends ActivityViewModel<ListActivity> {

    private String[] names;
    private ObservableList<Entries> entries = new ObservableArrayList<>();

    public ListViewModel(ListActivity activity) {
        super(activity);
        prepareEntries();
    }

    private void prepareEntries() {
        names = new String[] {"Jame", "Tomi", "Sara", "Serious", "Alex", "Karol"};
    }

    public ObservableList<Entries> getEntries() {
        return entries;
    }

    public void setEntries(ObservableList<Entries> entries) {
        this.entries = entries;
    }

    public void onClick(View view) {
        int position = new Random().nextInt(names.length - 1);
        entries.add(0, new Entries(names[position]));
    }

    public void onRemoveUser(View view) {
        if (entries.size() > 0) {
            entries.remove(0);
        }
    }
}
