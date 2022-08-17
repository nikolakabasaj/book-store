package graphpl.books.resolver.subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class SubscriptionPublisher<T> {
    private final int CORE_POOL_SIZE = 1;
    private final int INITIAL_DELAY = 0;
    private final int PERIOD = 2;
    private final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    public Publisher<T> publish(T entity) {
        Observable<T> observable = createObservable(entity);
        return getPublisherFromConnectableObservable(observable);
    }

    private Observable<T> createObservable(T entity) {
        return Observable.create(e -> {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
            executorService.scheduleAtFixedRate(() -> {
                e.onNext(entity);
            }, INITIAL_DELAY, PERIOD, TIME_UNIT);
        });
    }

    private Publisher<T> getPublisherFromConnectableObservable(Observable<T> observable) {
        ConnectableObservable<T> connectableObservable = observable.share().publish();
        connectableObservable.connect();
        return connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }
}
