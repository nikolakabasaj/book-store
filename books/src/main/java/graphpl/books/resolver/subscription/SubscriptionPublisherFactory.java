package graphpl.books.resolver.subscription;

import org.springframework.stereotype.Component;


@Component
public class SubscriptionPublisherFactory {
    public <T> SubscriptionPublisher<T> createSubscriptionPublisher(Class<T> clazz) {
        return new SubscriptionPublisher<>();
    }
}
