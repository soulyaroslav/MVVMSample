package soulyaroslav.com.mvvmgithubtest.Utils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by yaroslav on 6/19/17.
 */

public class SubscriptionUtil {

    private CompositeSubscription subscriptions;

    public void init() {
        subscriptions = new CompositeSubscription();
    }

    public void addSubscription(Subscription subscription) {
        if(subscriptions != null) {
            subscriptions.add(subscription);
        }
    }

    public void clearSubscription() {
        if(subscriptions != null) {
            subscriptions.clear();
        }
    }

}
